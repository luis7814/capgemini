package co.com.capgemini.bank.api.adapter.rest;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.capgemini.bank.core.commons.entities.ResponseTransaction;
import co.com.capgemini.bank.core.commons.entities.TransactionVo;
import co.com.capgemini.bank.core.shared.services.IGetLastTransactionService;
import co.com.capgemini.bank.core.shared.services.ISaveTransactionService;

/*
 * Clase : TransactionController.java
 * Comentario : Clase que se encarga de gestionar los servicios Rest Transaction
 * 
 */

@RestController
public class TransactionController {

	@Autowired
	private ISaveTransactionService iSaveTransactionService;
	
	@Autowired
	private IGetLastTransactionService iGetLastTransactionService; 
	
	@PostMapping("/api/1.0/transaction/save")
	public ResponseEntity<ResponseTransaction> saveTransaction(@RequestParam String customerId, @RequestParam String productNumber, @RequestParam int channelId, @RequestParam BigDecimal amount, @RequestParam int type){
		
		ResponseTransaction responseTransaction;
		
		responseTransaction = iSaveTransactionService.saveTransaction(customerId, productNumber, channelId, amount, type);
		
		return new ResponseEntity<>(responseTransaction, HttpStatus.OK);
	}
	
	@GetMapping("/api/1.0/transaction/getLast/{limit}/{customerId}/{productNumber}/get")
	public ResponseEntity<List<TransactionVo>> getLastTransaction(@PathVariable int limit, @PathVariable String customerId, @PathVariable String productNumber){
		
		List<TransactionVo> transactionVos;
		
		transactionVos = iGetLastTransactionService.getLastTransaction(limit, customerId, productNumber);
		
		return new ResponseEntity<>(transactionVos, HttpStatus.OK);
	}
}
