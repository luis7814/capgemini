package co.com.capgemini.bank.core.shared.services;

import java.math.BigDecimal;

import co.com.capgemini.bank.core.commons.entities.ResponseTransaction;

public interface ISaveTransactionService {
	
	ResponseTransaction saveTransaction(String customerId, String productNumber, int channelId, BigDecimal amount, int type);

}
