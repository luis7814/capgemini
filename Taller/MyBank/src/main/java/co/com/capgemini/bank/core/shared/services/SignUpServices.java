package co.com.capgemini.bank.core.shared.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.capgemini.bank.core.commons.entities.CustomerVo;
import co.com.capgemini.bank.core.commons.entities.ResponseService;
import co.com.capgemini.bank.core.commons.utilities.PrintMessage;
import co.com.capgemini.bank.core.commons.utilities.Utilities;
import co.com.capgemini.bank.repository.commons.dao.ICustomerDao;
import co.com.capgemini.bank.repository.commons.entities.Customer;

/*
 * Clase : SignUpServices.java
 * Comentario : Registra al usuario con el sistema para crear nuevos clientes 
 */

@Service
public class SignUpServices implements ISignUpServices{

	@Autowired
	private ICustomerDao iCustomerDao;
	
	@Override
	public ResponseService insertCustomer(CustomerVo customerVo) {
		
		String validateMessage = "";
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		Utilities utilities = new Utilities();
		Customer customer;
		ResponseService responseService = new ResponseService();
		
		try {
			
			if(customerVo != null) {
				if(customerVo.getName() == null || customerVo.getName().equals("")) {
					validateMessage = PrintMessage.VALIDATE_CUSTOMER_NAME;
				}
				
				if(customerVo.getSurName() == null || customerVo.getSurName().equals("")) {
					validateMessage = validateMessage + "\n" + PrintMessage.VALIDATE_CUSTOMER_SURNAME; 
				}
				
				if(customerVo.getCustomerId() == null || customerVo.getCustomerId().equals("")) {
					validateMessage = validateMessage + "\n" + PrintMessage.VALIDATE_CUSTOMER_ID;
				}
				
				if(customerVo.getEmail() == null || customerVo.getEmail().equals("")) {
					validateMessage = validateMessage + "\n" + PrintMessage.VALIDATE_CUSTOMER_EMAIL;
				}
				
				if(customerVo.getMobile() == null || customerVo.getMobile().equals("")) {
					validateMessage = validateMessage + "\n" + PrintMessage.VALIDATE_CUSTOMER_MOBILE;
				}
				
				if(customerVo.getPassword() == null || customerVo.getPassword().equals("")) {
					validateMessage = validateMessage + "\n" + PrintMessage.VALIDATE_CUSTOMER_PASSWORD;
				}
				
				if(validateMessage.equals("")) {
					customer = objectMapper.convertValue(customerVo, new TypeReference<Customer>() {});
					iCustomerDao.signUp(customer);
					responseService = utilities.responseService(PrintMessage.STATUS_CODE_OK, PrintMessage.STATUS_DESC_OK);
					
				}else {
					validateMessage = "Los siguientes datos son obligatorios : \n " + validateMessage;
					responseService = utilities.responseService(PrintMessage.STATUS_CODE_ERROR, validateMessage);
				}
			}
			
		}catch (Exception e) {
			responseService = utilities.responseService(PrintMessage.STATUS_CODE_ERROR, e.getMessage());
		}
		
		return responseService;
		
	}

}
