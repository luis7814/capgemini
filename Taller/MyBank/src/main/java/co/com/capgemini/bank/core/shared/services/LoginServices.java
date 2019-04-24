package co.com.capgemini.bank.core.shared.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.capgemini.bank.core.commons.entities.ResponseService;
import co.com.capgemini.bank.core.commons.utilities.PrintMessage;
import co.com.capgemini.bank.core.commons.utilities.Utilities;
import co.com.capgemini.bank.repository.commons.dao.ICustomerDao;
import co.com.capgemini.bank.repository.commons.entities.Customer;

@Service
public class LoginServices implements ILoginServices{

	@Autowired
	private ICustomerDao iCustomerDao;
	
	@Override
	public ResponseService login(String customerId, String password) {
		// TODO Auto-generated method stub
		
		String validateMessage = "";
		
		Utilities utilities = new Utilities();
		ResponseService responseService = new ResponseService();
		
		final Customer customer;
		
		try {
			
			if(customerId == null || customerId.equals("")) {
				validateMessage = PrintMessage.VALIDATE_CUSTOMER_ID;
			}
			
			if(password == null || password.equals("")) {
				validateMessage = validateMessage + " " + PrintMessage.VALIDATE_CUSTOMER_PASSWORD;
			}
			
			if(validateMessage.equals("")) {
				
				customer = iCustomerDao.login(customerId, password);
				responseService = utilities.responseService(PrintMessage.STATUS_CODE_OK, customer.getCustomerId());
				
				
			}else {
				validateMessage = "Los siguientes datos son obligatorios : \n " + validateMessage;
				responseService = utilities.responseService(PrintMessage.STATUS_CODE_ERROR, validateMessage);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return responseService;
	}

}
