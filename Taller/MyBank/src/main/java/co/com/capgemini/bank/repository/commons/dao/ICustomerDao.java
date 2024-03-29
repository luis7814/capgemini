package co.com.capgemini.bank.repository.commons.dao;

import co.com.capgemini.bank.repository.commons.entities.Customer;

public interface ICustomerDao {
	
	void signUp(Customer customer) throws Exception;
	Customer getCustomerById(String customerId) throws Exception;
	Customer login(String customerId, String password) throws Exception;
	Customer getCustomerById(Long id)throws Exception;
	

}
