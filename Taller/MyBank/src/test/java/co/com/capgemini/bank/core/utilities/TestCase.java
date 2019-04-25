package co.com.capgemini.bank.core.utilities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import co.com.capgemini.bank.core.commons.entities.CustomerVo;
import co.com.capgemini.bank.repository.commons.entities.Customer;
import co.com.capgemini.bank.repository.commons.entities.CustomerProduct;
import co.com.capgemini.bank.repository.commons.entities.Product;

public class TestCase {
	
	public Customer dataTestCustomer() {
		
		Customer customer = new Customer();
		customer.setId(1L);
		customer.setName("John");
		customer.setSurName("Lydon");
		customer.setCustomerId("1012345");
		customer.setEmail("john.lydon@sexpistols.com");
		customer.setMobile("1200300400");
		customer.setPhone("");
		customer.setPassword("132");
		
		return customer;
		
	}
	
	public CustomerVo dataTestCustomerVo() {
		
		CustomerVo customerVo = new CustomerVo();
		customerVo.setId("1");
		customerVo.setName("John");
		customerVo.setSurName("Lydon");
		customerVo.setCustomerId("1012345");
		customerVo.setEmail("john.lydon@sexpistols.com");
		customerVo.setMobile("1200300400");
		customerVo.setPhone("");
		customerVo.setPassword("132");
		
		return customerVo;
		
		
	}
	
	public CustomerProduct dataTestCustomerProduct() {
		
		CustomerProduct customerProduct = new CustomerProduct();
		customerProduct.setId(1L);
		customerProduct.setCustomerId(1L);
		customerProduct.setProductoId(1L);
		customerProduct.setCreationDate(null);
		customerProduct.setTerminationDate(null);
		customerProduct.setBalance(BigDecimal.valueOf(30000L));
		customerProduct.setStatus("ACTIVE");
		customerProduct.setProductNumber("1000000001");
		
		return customerProduct;
		
	}
	
	public Product dataTestProduct() {
		
		Product product = new Product();
		product.setId(1L);
		product.setName("Savings Account");
		product.setDescription("Savings Account");
		product.setStatus("ACTIVE");
		
		return product;
		
	}
	
	public List<Product> dataTestProducts() {
		
		Product product = null;
		List<Product> products = new ArrayList<>();
		
		product = new Product();
		product.setId(1L);
		product.setName("Savings Account");
		product.setDescription("Savings Account");
		product.setStatus("ACTIVE");
		products.add(product);
		
		product = new Product();
		product.setId(2L);
		product.setName("Checking Account");
		product.setDescription("Checking Account");
		product.setStatus("ACTIVE");
		products.add(product);
		
		return products;
		
	}

}
