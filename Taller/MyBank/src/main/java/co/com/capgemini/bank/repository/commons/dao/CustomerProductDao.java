package co.com.capgemini.bank.repository.commons.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.capgemini.bank.repository.commons.entities.CustomerProduct;
import co.com.capgemini.bank.repository.shared.repository.ICustomerProductRepository;

@Repository
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

	@Override
	public CustomerProduct getCustomerProductById(Long customerId) throws Exception {
		
		CustomerProduct customerProduct = null;
		
		customerProduct = iCustomerProductRepository.findByCustomerId(customerId);
		
		return customerProduct;
	}

	@Override
	public void createCustomerProduct(CustomerProduct customerProduct) throws Exception {
		
		customerProduct.setId(iCustomerProductRepository.findTopByOrderByIdDesc().getId() + 1);
		iCustomerProductRepository.saveAndFlush(customerProduct);
		
	}

}
