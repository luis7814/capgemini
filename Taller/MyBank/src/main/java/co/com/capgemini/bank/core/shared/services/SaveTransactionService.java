package co.com.capgemini.bank.core.shared.services;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.capgemini.bank.core.commons.entities.ResponseTransaction;
import co.com.capgemini.bank.core.commons.entities.TransactionVo;
import co.com.capgemini.bank.core.commons.utilities.PrintMessage;
import co.com.capgemini.bank.repository.commons.dao.ICustomerDao;
import co.com.capgemini.bank.repository.commons.dao.ICustomerProductDao;
import co.com.capgemini.bank.repository.commons.dao.ITransactionDao;
import co.com.capgemini.bank.repository.commons.entities.Customer;
import co.com.capgemini.bank.repository.commons.entities.CustomerProduct;
import co.com.capgemini.bank.repository.commons.entities.Transaction;

/*
 * Clase : SaveTransactionService.java
 * Comentario : Almacena la información de la transacción 
 */

@Service
public class SaveTransactionService implements ISaveTransactionService{

	
	@Autowired
	private ITransactionDao iTransactionDao;
	
	@Autowired
	private ICustomerProductDao iCustomerProductDao; 
	
	@Autowired
	private ICustomerDao iCustomerDao;
	
	
	@Override
	public ResponseTransaction saveTransaction(String customerId, String productNumber, int channelId, BigDecimal amount, int type) {
		
		ResponseTransaction responseTransaction = null;
		Transaction transaction;
		CustomerProduct customerProduct;
		Customer customer;
		
		
		
		TransactionVo transactionVo;
		List<TransactionVo> transactionVos;
		
		Calendar calendar = Calendar.getInstance();
		
		try {
			
			responseTransaction = new ResponseTransaction();
			
			customer = iCustomerDao.getCustomerById(customerId);
			
			if(customer != null) {
				
				customerProduct = iCustomerProductDao.getCustomerProduct(customer.getId(), productNumber);
				
				if(customerProduct != null) {
					
					transaction = new Transaction();
					transaction.setCustomerProductId(customerProduct.getId());
					transaction.setChannelId(Long.parseLong(String.valueOf(channelId)));
					transaction.setAmount(amount);
					transaction.setDate(new Date(calendar.getTime().getTime()));
					transaction.setStatus(PrintMessage.STATUS_TRANSACTION);
					transaction.setType(Long.parseLong(String.valueOf(type)));
					transaction.setTransactionNumber(1780L);
					
					transaction = iTransactionDao.saveTransaction(transaction);
					
					if(transaction != null) {
						
						transactionVos = new ArrayList<>();
						transactionVo = new TransactionVo();
						transactionVo.setCustomerId(customerId);
						transactionVo.setProductNumber(productNumber);
						transactionVo.setChannelId(transaction.getChannelId());
						transactionVo.setAmount(Long.parseLong(transaction.getAmount().toString()));
						transactionVo.setDate(transaction.getDate());
						transactionVo.setStatus(transaction.getStatus());
						transactionVo.setType(transaction.getType());
						transactionVo.setTransactionNumber(transaction.getTransactionNumber());
						transactionVos.add(transactionVo);
						
						responseTransaction.setMessage("success");
						responseTransaction.setDetail(transactionVos);
						
					}else {

						responseTransaction.setMessage("Customer product not found");
						responseTransaction.setDetail(null);
					}
					
				}else {
					responseTransaction.setMessage("Customer product not found");
					responseTransaction.setDetail(null);
				}
			}else {
				responseTransaction.setMessage("Customer product not found");
				responseTransaction.setDetail(null);
			}
			
						
		}catch (Exception e) {
			responseTransaction.setMessage("Customer product not found");
			responseTransaction.setDetail(null);
		}
		
		return responseTransaction;
	}
	
	

}
