package co.com.capgemini.bank.api.adapter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.capgemini.bank.core.commons.entities.CustomerProductVo;
import co.com.capgemini.bank.core.commons.entities.ResponseService;
import co.com.capgemini.bank.core.shared.services.ICreateCustomerProductService;
import co.com.capgemini.bank.core.shared.services.IGetCustomerProductService;

@RestController
public class CustomerProductController {

	@Autowired
	private IGetCustomerProductService iGetCustomerProductService; 
	
	@Autowired
	private ICreateCustomerProductService iCreateCustomerProductService; 
	
	
	@GetMapping("/api/1.0/product/{customerId}/{productNumber}/get")
	public ResponseEntity<CustomerProductVo> getCustomerProduct(@PathVariable String customerId, @PathVariable String productNumber){
		
		CustomerProductVo customerProductVo = null;
		
		customerProductVo = iGetCustomerProductService.getCustomerProduct(customerId, productNumber);
		
		return new ResponseEntity<>(customerProductVo, HttpStatus.OK);
		
	}
	
	@GetMapping("/api/1.0/product/{customerId}/get")
	public ResponseEntity<CustomerProductVo> getCustomerProductById(@PathVariable String customerId){
		
		CustomerProductVo customerProductVo = null;
		
		customerProductVo = iGetCustomerProductService.getCustomerProductById(customerId);
		
		return new ResponseEntity<>(customerProductVo, HttpStatus.OK);
		
	}
	
	@PostMapping("/api/1.0/product/createCustomerProduct")
	public ResponseEntity<ResponseService> createCustomerProduct(@RequestParam int productId, String customerId){
		
		ResponseService responseService = null;
		
		responseService = iCreateCustomerProductService.createCustomerProduct(productId, customerId);
		
		if(responseService == null) {
			return new ResponseEntity<>(responseService, HttpStatus.INTERNAL_SERVER_ERROR);
		}else {
			return new ResponseEntity<>(responseService, HttpStatus.OK);
		}
		
		
		
	}
}
