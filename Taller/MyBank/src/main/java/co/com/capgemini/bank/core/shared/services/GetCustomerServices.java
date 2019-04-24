package co.com.capgemini.bank.core.shared.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.capgemini.bank.core.commons.entities.CustomerVo;
import co.com.capgemini.bank.repository.commons.dao.ICustomerDao;
import co.com.capgemini.bank.repository.commons.entities.Customer;

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
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return customerVo;
	}

}
