package co.com.capgemini.bank.core.shared.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.capgemini.bank.core.commons.entities.CustomerVo;
import co.com.capgemini.bank.core.commons.utilities.PrintMessage;
import co.com.capgemini.bank.core.utilities.TestCase;
import co.com.capgemini.bank.repository.commons.dao.ICustomerDao;
import co.com.capgemini.bank.repository.commons.entities.Customer;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class SignUpTest {
	
	@InjectMocks
	private SignUpServices signUpServices; 
	
	@Mock
	private ICustomerDao iCustomerDao;

	@Test
	public void contextLoads() {
		
		TestCase testCase = new TestCase();
		CustomerVo customerVo;
		Customer customer;
		
		try {
			
			for(int a = 0; a < 3; a++) {
				
				if(a == 0) {
					customerVo = testCase.dataTestCustomerVo();
					customer = testCase.dataTestCustomer();
					//when(iCustomerDao.signUp(customer)).thenReturn(null);
					assertEquals(PrintMessage.STATUS_CODE_OK, signUpServices.insertCustomer(customerVo).getStatus().getStatus_code());
				}
				
				if(a == 1) {
					customerVo = testCase.dataTestCustomerVo();
					customerVo.setEmail(null);
					assertEquals(PrintMessage.STATUS_CODE_ERROR, signUpServices.insertCustomer(customerVo).getStatus().getStatus_code());
				}
				
				if(a == 2) {
					customerVo = null;
					assertEquals(PrintMessage.STATUS_CODE_ERROR, signUpServices.insertCustomer(customerVo).getStatus().getStatus_code());
				}
				
				
			}
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
