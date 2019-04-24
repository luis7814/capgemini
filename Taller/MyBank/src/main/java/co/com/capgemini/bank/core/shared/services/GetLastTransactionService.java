package co.com.capgemini.bank.core.shared.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.capgemini.bank.core.commons.entities.TransactionVo;
import co.com.capgemini.bank.repository.commons.dao.ICustomerDao;
import co.com.capgemini.bank.repository.commons.dao.ICustomerProductDao;
import co.com.capgemini.bank.repository.commons.dao.ITransactionDao;
import co.com.capgemini.bank.repository.commons.entities.Customer;
import co.com.capgemini.bank.repository.commons.entities.CustomerProduct;
import co.com.capgemini.bank.repository.commons.entities.Transaction;

@Service
public class GetLastTransactionService implements IGetLastTransactionService{

	
	@Autowired
	private ITransactionDao iTransactionDao;
	
	@Autowired
	private ICustomerProductDao iCustomerProductDao; 
	
	@Autowired
	private ICustomerDao iCustomerDao;
	
	@Override
	public List<TransactionVo> getLastTransaction(int limit, String customerId, String productNumber) {
		
		CustomerProduct customerProduct;
		Customer customer;
		
		TransactionVo transactionVo;
		List<TransactionVo> transactionVos = null;
		List<Transaction> transactions;
		
		try {
			
			
			customer = iCustomerDao.getCustomerById(customerId);
			
			if(customer != null) {
				
				customerProduct = iCustomerProductDao.getCustomerProduct(customer.getId(), productNumber);
				
				if(customerProduct != null) {
					
					transactions = iTransactionDao.getLastTransaction(customerProduct.getId());
					
					transactionVos = new ArrayList<>();
					
					for(int a = 0; a < transactions.size(); a++) {
						
						if(a < limit) {
							
							transactionVo = new TransactionVo();
							transactionVo.setCustomerId(customer.getCustomerId());
							transactionVo.setProductNumber(productNumber);
							transactionVo.setChannelId(transactions.get(a).getChannelId());
							transactionVo.setAmount(Long.parseLong(transactions.get(a).getAmount().toString()));
							transactionVo.setDate(transactions.get(a).getDate());
							transactionVo.setStatus(transactions.get(a).getStatus());
							transactionVo.setType(transactions.get(a).getType());
							transactionVo.setTransactionNumber(transactions.get(a).getTransactionNumber());
							transactionVos.add(transactionVo);
						}else {
							break;
						}
					}
				}			
			}
			
			
		}catch (Exception e) {
			
		}
		
		return transactionVos;
	}
	
	

}
