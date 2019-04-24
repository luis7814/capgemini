package co.com.capgemini.bank.core.commons.entities;

import java.util.List;

public class ResponseTransaction {
	
	private String message;
	private List<TransactionVo> detail;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public List<TransactionVo> getDetail() {
		return detail;
	}
	
	public void setDetail(List<TransactionVo> detail) {
		this.detail = detail;
	}
	
	
	

}
