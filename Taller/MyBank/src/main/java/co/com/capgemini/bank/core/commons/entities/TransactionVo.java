package co.com.capgemini.bank.core.commons.entities;

import java.util.Date;

public class TransactionVo {
	
	private String customerId;
	private String productNumber;
	private Long channelId;
	private Long amount;
	private Date date;
	private String status;
	private Long type;
	private Long transactionNumber;
	
	public String getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getProductNumber() {
		return productNumber;
	}
	
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	
	public Long getChannelId() {
		return channelId;
	}
	
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	
	public Long getAmount() {
		return amount;
	}
	
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Long getType() {
		return type;
	}
	
	public void setType(Long type) {
		this.type = type;
	}
	
	public Long getTransactionNumber() {
		return transactionNumber;
	}
	
	public void setTransactionNumber(Long transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	
}
