package co.com.capgemini.bank.core.shared.services;

import co.com.capgemini.bank.core.commons.entities.CustomerProductVo;

public interface IGetCustomerProductService {

	CustomerProductVo getCustomerProduct(String customerId, String productNumber);
	CustomerProductVo getCustomerProductById(String customerId);
}
