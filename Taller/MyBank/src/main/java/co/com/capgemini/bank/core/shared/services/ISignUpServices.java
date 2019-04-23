package co.com.capgemini.bank.core.shared.services;

import co.com.capgemini.bank.core.commons.entities.CustomerVo;
import co.com.capgemini.bank.core.commons.entities.ResponseService;

public interface ISignUpServices {
	
	ResponseService insertCustomer(CustomerVo customerVo);

}
