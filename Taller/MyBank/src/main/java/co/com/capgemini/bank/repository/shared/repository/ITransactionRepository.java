package co.com.capgemini.bank.repository.shared.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.capgemini.bank.repository.commons.entities.Transaction;

public interface ITransactionRepository extends JpaRepository<Transaction, Long>{

	Transaction findTopByOrderByIdDesc();
	List<Transaction> findByCustomerProductIdOrderByIdDesc(Long customerProductoId);
}
