package co.com.capgemini.bank.repository.shared.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.capgemini.bank.repository.commons.entities.CustomerProduct;

public interface ICustomerProductRepository extends JpaRepository<CustomerProduct, Long> {

	CustomerProduct findByCustomerIdAndProductNumber(Long customerId, String productNumber);

}
