package co.com.capgemini.bank.core.commons.entities;

public class CustomerProductVo {

	private String customer_id;
	private String product_name;
	private String creation_date;
	private String termination_date;
	private String balance;
	private String status;
	private String product_number;
	
	public String getCustomer_id() {
		return customer_id;
	}
	
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	
	public String getProduct_name() {
		return product_name;
	}
	
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	public String getCreation_date() {
		return creation_date;
	}
	
	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}
	
	public String getTermination_date() {
		return termination_date;
	}
	
	public void setTermination_date(String termination_date) {
		this.termination_date = termination_date;
	}
	
	public String getBalance() {
		return balance;
	}
	
	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getProduct_number() {
		return product_number;
	}
	
	public void setProduct_number(String product_number) {
		this.product_number = product_number;
	}
	
	
	
}
