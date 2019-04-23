package co.com.capgemini.bank.repository.commons.dao;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.capgemini.bank.repository.commons.entities.CustomerProduct;
import co.com.capgemini.bank.repository.shared.repository.ICustomerProductRepository;

public class CustomerProductDao implements ICustomerProductDao{

	@Autowired
	private ICustomerProductRepository iCustomerProductRepository;
	
	@Override
	public CustomerProduct getCustomerProduct(Long customerId, String productNumber) throws Exception {
		// TODO Auto-generated method stub
		
		CustomerProduct customerProduct = null;
		
		customerProduct = iCustomerProductRepository.findByCustomerIdAndProductNumber(customerId, productNumber);
		
		return customerProduct;
	}

}
