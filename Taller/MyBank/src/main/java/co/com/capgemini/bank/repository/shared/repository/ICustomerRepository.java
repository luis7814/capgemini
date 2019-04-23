package co.com.capgemini.bank.repository.shared.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.capgemini.bank.repository.commons.entities.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Long>{
	
	Customer findByCustomerIdAndPassword(String customerId, String password);

}
