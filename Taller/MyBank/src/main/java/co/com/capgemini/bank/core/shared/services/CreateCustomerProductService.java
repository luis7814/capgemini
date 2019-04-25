package co.com.capgemini.bank.core.shared.services;

import java.util.Calendar;
import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.capgemini.bank.core.commons.entities.ResponseService;
import co.com.capgemini.bank.core.commons.utilities.PrintMessage;
import co.com.capgemini.bank.core.commons.utilities.Utilities;
import co.com.capgemini.bank.repository.commons.dao.ICustomerDao;
import co.com.capgemini.bank.repository.commons.dao.ICustomerProductDao;
import co.com.capgemini.bank.repository.commons.dao.IProductDao;
import co.com.capgemini.bank.repository.commons.entities.Customer;
import co.com.capgemini.bank.repository.commons.entities.CustomerProduct;
import co.com.capgemini.bank.repository.commons.entities.Product;

/*
 * Clase : CreateCustomerProductService.java
 * Comentario : Crear producto para el cliente 
 */

@Service
public class CreateCustomerProductService implements ICreateCustomerProductService{

	@Autowired
	private ICustomerDao iCustomerDao;
	
	@Autowired
	private IProductDao iProductDao;
	
	@Autowired
	private ICustomerProductDao iCustomerProductDao; 
	
	@Override
	public ResponseService createCustomerProduct(int productId, String customerId) {
		
		Customer customer = null;
		Product product = null;
		CustomerProduct customerProduct;
		ResponseService responseService = null;
		
		Utilities utilities = new Utilities();
		Calendar calendar = Calendar.getInstance();
		
		try {
			
			
			customer = iCustomerDao.getCustomerById(customerId);
			
			if(customer != null) {
				
				product = iProductDao.getProductoId(Long.parseLong(String.valueOf(productId)));
				
				if(product != null) {
					
					customerProduct = new CustomerProduct();
					customerProduct.setCustomerId(customer.getId());
					customerProduct.setProductoId(product.getId());
					customerProduct.setCreationDate(new Date(calendar.getTime().getTime()));
					customerProduct.setBalance(BigDecimal.valueOf(11111L));
					customerProduct.setStatus(PrintMessage.STATUS);
					customerProduct.setProductNumber("123456789");
					
					iCustomerProductDao.createCustomerProduct(customerProduct);
					
					responseService = utilities.responseService(PrintMessage.STATUS_CODE_OK, customerProduct.getProductNumber());
					
				}else {
					responseService = utilities.responseService(PrintMessage.STATUS_CODE_ERROR, "El producto nose encuentra registrado.");
				}
				
			}else {
				responseService = utilities.responseService(PrintMessage.STATUS_CODE_OK, "El customerId no existe.");
			}
			
			
		}catch (Exception e) {
			responseService = utilities.responseService(PrintMessage.STATUS_CODE_ERROR, "Error técnico.");
		}
		return responseService;
		
	}

}
