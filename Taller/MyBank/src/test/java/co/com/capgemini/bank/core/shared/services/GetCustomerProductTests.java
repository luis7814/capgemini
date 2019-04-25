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
import co.com.capgemini.bank.repository.commons.dao.ICustomerProductDao;
import co.com.capgemini.bank.repository.commons.dao.IProductDao;
import co.com.capgemini.bank.repository.commons.entities.Customer;
import co.com.capgemini.bank.repository.commons.entities.CustomerProduct;
import co.com.capgemini.bank.repository.commons.entities.Product;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class GetCustomerProductTests {
	
	
	@InjectMocks
	private GetCustomerProductService getCustomerProductService;
	
	@Mock
	private IProductDao iProductDao;
	
	@Mock
	private ICustomerProductDao iCustomerProductDao;
	
	@Mock
	private ICustomerDao iCustomerDao;
	
	@Test
	public void contextLoads() {
		
		TestCase testCase = new TestCase();
		CustomerProduct customerProduct;
		Product product;
		Customer customer;
		
		String customerId = null;
		String productNumber = null;
		
		try {
			
			for(int a = 0; a < 3; a++) {
				
				if(a == 0) {
					
					customerProduct = testCase.dataTestCustomerProduct();
					when(iCustomerProductDao.getCustomerProduct(Long.parseLong(customerId), productNumber)).thenReturn(customerProduct);
					
					product = testCase.dataTestProduct();
					when(iProductDao.getProductoId(customerProduct.getCustomerId())).thenReturn(product);
					
					customer = testCase.dataTestCustomer();
					when(iCustomerDao.getCustomerById(customerProduct.getCustomerId())).thenReturn(customer);
					
					assertNotNull(getCustomerProductService.getCustomerProduct(customerId, productNumber));
					
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	

}