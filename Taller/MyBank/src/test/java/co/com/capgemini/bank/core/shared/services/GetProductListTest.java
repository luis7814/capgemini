package co.com.capgemini.bank.core.shared.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import co.com.capgemini.bank.core.commons.utilities.PrintMessage;
import co.com.capgemini.bank.core.utilities.TestCase;
import co.com.capgemini.bank.repository.commons.dao.IProductDao;
import co.com.capgemini.bank.repository.commons.entities.Product;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class GetProductListTest {

	
	@InjectMocks
	private GetProductListService getProductListService;
	
	@Mock
	private IProductDao iProductDao;

	@Test
	public void contextLoads() {
		
		TestCase testCase = new TestCase();
		List<Product> products;
		
		try {
			
			
			for(int a = 0; a < 2; a++) {
				
				if(a == 0) {
					
					products = testCase.dataTestProducts();
					when(iProductDao.getProductList()).thenReturn(products);
					assertNotNull(getProductListService.getProductList());
				}
				
				if(a == 2) {
					products = null;
					when(iProductDao.getProductList()).thenReturn(products);
					assertNull(getProductListService.getProductList());
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
