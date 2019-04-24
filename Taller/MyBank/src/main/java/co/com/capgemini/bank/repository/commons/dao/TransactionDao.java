package co.com.capgemini.bank.repository.commons.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.capgemini.bank.repository.commons.entities.Transaction;
import co.com.capgemini.bank.repository.shared.repository.ITransactionRepository;

@Repository
public class TransactionDao implements ITransactionDao{

	@Autowired
	private ITransactionRepository iTransactionRepository; 
	
	@Override
	public Transaction saveTransaction(Transaction transaction) throws Exception {
		
		transaction.setId(iTransactionRepository.findTopByOrderByIdDesc().getId() + 1);
		iTransactionRepository.saveAndFlush(transaction);
		
		return transaction;
	}

	@Override
	public List<Transaction> getLastTransaction(Long customerProductId) throws Exception {
		
		List<Transaction> transactions;
		transactions = iTransactionRepository.findByCustomerProductIdOrderByIdDesc(customerProductId);
		
		return transactions;
	}
	

}
