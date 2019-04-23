package co.com.capgemini.bank.core.shared.services;

import co.com.capgemini.bank.core.commons.entities.ResponseService;

public interface ILoginServices {
	
	ResponseService login(String customerId, String password);

}
