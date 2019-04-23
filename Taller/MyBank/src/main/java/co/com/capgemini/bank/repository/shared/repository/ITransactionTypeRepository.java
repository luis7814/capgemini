package co.com.capgemini.bank.repository.shared.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.capgemini.bank.repository.commons.entities.TransactionType;

public interface ITransactionTypeRepository extends JpaRepository<TransactionType, Long>{

}
