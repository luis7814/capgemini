package co.com.capgemini.bank.core.shared.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.capgemini.bank.core.commons.utilities.PrintMessage;
import co.com.capgemini.bank.core.utilities.TestCase;
import co.com.capgemini.bank.repository.commons.dao.ICustomerDao;
import co.com.capgemini.bank.repository.commons.entities.Customer;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class LoginTests {
	
	@InjectMocks
	private LoginServices loginServices;
	
	@Mock
	private ICustomerDao iCustomerDao;

	@Test
	public void contextLoads() {
		
		TestCase testCase = new TestCase();
		Customer customer;
		
		String customerId;
		String password;
		
		try {
			
			customerId = "1012345";
			password = "132";
			
			for(int a = 0; a < 2; a++) {
				
				if(a == 0) {
					
					customer = testCase.dataTestCustomer();
					when(iCustomerDao.login(customerId, password)).thenReturn(customer);
					assertEquals(PrintMessage.STATUS_CODE_OK, loginServices.login(customerId, password).getStatus().getStatus_code());
				}
				
				if(a == 1) {
					customer = null;
					when(iCustomerDao.login(customerId, password)).thenReturn(customer);
					assertEquals(PrintMessage.STATUS_CODE_ERROR, loginServices.login(customerId, password).getStatus().getStatus_code());
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
