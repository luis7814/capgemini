package co.com.capgemini.bank.core.shared.services;

import co.com.capgemini.bank.core.commons.entities.CustomerVo;

public interface IGetCustomerServices {
	
	CustomerVo getCustomerById(String customerId);

}
