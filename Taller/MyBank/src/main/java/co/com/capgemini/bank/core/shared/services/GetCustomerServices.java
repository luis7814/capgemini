package co.com.capgemini.bank.core.shared.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.capgemini.bank.core.commons.entities.CustomerVo;
import co.com.capgemini.bank.repository.commons.dao.ICustomerDao;
import co.com.capgemini.bank.repository.commons.entities.Customer;

/*
 * Clase : GetCustomerServices.java
 * Comentario : Obtiene la información del cliente por identificador de cliente (identificador de documento) 
 */

@Service
public class GetCustomerServices implements IGetCustomerServices{

	
	@Autowired
	private ICustomerDao iCustomerDao;
	
	@Override
	public CustomerVo getCustomerById(String customerId) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		Customer customer;
		CustomerVo customerVo = null;
		
		try {
			
			customer = iCustomerDao.getCustomerById(customerId);
			
			if(customer != null) {
				
				customerVo = objectMapper.convertValue(customer, new TypeReference<CustomerVo>() {});
				customerVo.setId(null);
				customerVo.setPassword("******");
			}else {
				customerVo = null;
			}
			
		}catch (Exception e) {
			customerVo = null;
		}
		
		return customerVo;
	}

}
