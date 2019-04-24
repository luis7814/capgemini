package co.com.capgemini.bank.repository.commons.dao;

import co.com.capgemini.bank.repository.commons.entities.CustomerProduct;

public interface ICustomerProductDao {

	CustomerProduct getCustomerProduct(Long customerId, String productNumber) throws Exception;
	CustomerProduct getCustomerProductById(Long customerId) throws Exception;
	void createCustomerProduct(CustomerProduct customerProduct)throws Exception;
	
}
