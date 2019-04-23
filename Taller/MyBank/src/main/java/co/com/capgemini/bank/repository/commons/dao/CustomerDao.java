package co.com.capgemini.bank.repository.commons.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.capgemini.bank.repository.commons.entities.Customer;
import co.com.capgemini.bank.repository.shared.repository.ICustomerRepository;

@Repository
public class CustomerDao implements ICustomerDao {

	@Autowired
	private ICustomerRepository iCustomerRepository; 
	
	
	@Override
	public void signUp(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		
		iCustomerRepository.saveAndFlush(customer);
		
	}


	@Override
	public Customer getCustomerById(Long customerId) throws Exception {
		// TODO Auto-generated method stub
		
		Customer customer = null;
		customer = iCustomerRepository.getOne(customerId);
		
		return customer;
	}


	@Override
	public Customer login(String customerId, String password) throws Exception {
		// TODO Auto-generated method stub
		
		Customer customer = null;
		customer = iCustomerRepository.findByCustomerIdAndPassword(customerId, password);
		
		return customer;
	}

}
