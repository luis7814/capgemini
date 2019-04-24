package co.com.capgemini.bank.core.shared.services;

import java.util.List;

import co.com.capgemini.bank.core.commons.entities.TransactionVo;

public interface IGetLastTransactionService {
	
	List<TransactionVo> getLastTransaction(int limit, String customerId, String productNumber);

}
