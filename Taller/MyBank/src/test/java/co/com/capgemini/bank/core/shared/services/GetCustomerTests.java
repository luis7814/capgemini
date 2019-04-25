package co.com.capgemini.bank.core.shared.services;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.capgemini.bank.core.utilities.TestCase;
import co.com.capgemini.bank.repository.commons.dao.ICustomerDao;
import co.com.capgemini.bank.repository.commons.entities.Customer;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class GetCustomerTests {
	
	@InjectMocks
	private GetCustomerServices getCustomerServices;
	
	@Mock
	private ICustomerDao iCustomerDao;
	
	@Test
	public void contextLoads() {
		
		TestCase testCase = new TestCase();
		Customer customer;
		
		String customerId;
		
		try {
			
			customerId = "1012345";
			
			for(int a = 0; a < 2; a++) {
				
				if(a == 0) {
					
					customer = testCase.dataTestCustomer();
					when(iCustomerDao.getCustomerById(customerId)).thenReturn(customer);
					assertNotNull(getCustomerServices.getCustomerById(customerId));
				}
				
				if(a == 1) {
					customer = null;
					when(iCustomerDao.getCustomerById(customerId)).thenReturn(customer);
					assertNotNull(getCustomerServices.getCustomerById(customerId));
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}


}
