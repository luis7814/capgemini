package co.com.capgemini.bank.core.shared.services;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.capgemini.bank.core.commons.entities.CustomerProductVo;
import co.com.capgemini.bank.repository.commons.dao.ICustomerDao;
import co.com.capgemini.bank.repository.commons.dao.ICustomerProductDao;
import co.com.capgemini.bank.repository.commons.dao.IProductDao;
import co.com.capgemini.bank.repository.commons.entities.Customer;
import co.com.capgemini.bank.repository.commons.entities.CustomerProduct;
import co.com.capgemini.bank.repository.commons.entities.Product;

@Service
public class GetCustomerProductService implements IGetCustomerProductService{

	@Autowired
	private IProductDao iProductDao;
	
	@Autowired
	private ICustomerProductDao iCustomerProductDao;
	
	@Autowired ICustomerDao iCustomerDao;
	
	@Override
	public CustomerProductVo getCustomerProduct(String customerId, String productNumber) {
		
		CustomerProductVo customerProductVo = new CustomerProductVo();
		CustomerProduct customerProduct = null;
		Product product = null;
		Customer customer = null;
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			
			customerProduct = iCustomerProductDao.getCustomerProduct(Long.parseLong(customerId), productNumber);
			
			if(customerProduct != null) {
				
				product = iProductDao.getProductoId(customerProduct.getCustomerId());
				
				if(product != null) {
					
					customer = iCustomerDao.getCustomerById(customerProduct.getCustomerId());
					
					if(customer != null) {
						
						customerProductVo.setCustomer_id(customer.getCustomerId());
						customerProductVo.setProduct_name(product.getName());
						customerProductVo.setCreation_date(simpleDateFormat.format(customerProduct.getCreationDate()));
						customerProductVo.setTermination_date(customerProduct.getTerminationDate() == null ? null : simpleDateFormat.format(customerProduct.getTerminationDate()));
						customerProductVo.setBalance(customerProduct.getBalance().toString());
						customerProductVo.setStatus(customerProduct.getStatus().toString());
						customerProductVo.setProduct_number(customerProduct.getProductNumber());
						
					}
				}
			}	
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return customerProductVo;
	}

	@Override
	public CustomerProductVo getCustomerProductById(String customerId) {
		
		CustomerProductVo customerProductVo = new CustomerProductVo();
		CustomerProduct customerProduct = null;
		Product product = null;
		Customer customer = null;
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			
			customer = iCustomerDao.getCustomerById(customerId);
			
			if(customer != null) {
				
				customerProduct = iCustomerProductDao.getCustomerProductById(customer.getId());
				
				if(customerProduct != null) {
					
					product = iProductDao.getProductoId(customerProduct.getCustomerId());
					
					if(product != null) {
								
						customerProductVo.setCustomer_id(customer.getCustomerId());
						customerProductVo.setProduct_name(product.getName());
						customerProductVo.setCreation_date(simpleDateFormat.format(customerProduct.getCreationDate()));
						customerProductVo.setTermination_date(customerProduct.getTerminationDate() == null ? null : simpleDateFormat.format(customerProduct.getTerminationDate()));
						customerProductVo.setBalance(customerProduct.getBalance().toString());
						customerProductVo.setStatus(customerProduct.getStatus().toString());
						customerProductVo.setProduct_number(customerProduct.getProductNumber());
							
					}
				}
			}	
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return customerProductVo;
		
	}
	

}
