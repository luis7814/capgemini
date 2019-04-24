package co.com.capgemini.bank.repository.commons.dao;

import java.util.List;

import co.com.capgemini.bank.repository.commons.entities.Transaction;

public interface ITransactionDao {
	
	Transaction saveTransaction(Transaction transaction) throws Exception;
	List<Transaction> getLastTransaction(Long customerProductId) throws Exception;

}
