package co.com.capgemini.bank.core.shared.services;

import co.com.capgemini.bank.core.commons.entities.ResponseService;

public interface ICreateCustomerProductService {
	
	ResponseService createCustomerProduct(int productId, String customerId);

}
