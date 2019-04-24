package co.com.capgemini.bank.api.adapter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.capgemini.bank.core.commons.entities.CustomerVo;
import co.com.capgemini.bank.core.commons.entities.ResponseService;
import co.com.capgemini.bank.core.commons.utilities.JwtToken;
import co.com.capgemini.bank.core.commons.utilities.PrintMessage;
import co.com.capgemini.bank.core.shared.services.IGetCustomerServices;
import co.com.capgemini.bank.core.shared.services.ILoginServices;
import co.com.capgemini.bank.core.shared.services.ISignUpServices;

@RestController
public class CustomerController {

	@Autowired
	private ILoginServices iLoginServices;
	
	@Autowired
	private ISignUpServices iSignUpServices;
	
	@Autowired
	private IGetCustomerServices iGetCustomerServices;
	
	private ResponseService responseService;
	
	@PostMapping("/api/1.0/customer/sign-up")
	public ResponseEntity<ResponseService> signUp(@RequestBody CustomerVo customerVo){
		
		responseService = iSignUpServices.insertCustomer(customerVo);
		
		return new ResponseEntity<>(responseService, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<ResponseService> login(@RequestParam String customerId, @RequestParam String password){
		
		JwtToken jwtToken;
		String token;
		HttpHeaders httpHeaders;
		
		responseService = iLoginServices.login(customerId, password);
		
		if(responseService.getStatus().getStatus_code() == 0){
			
			jwtToken = new JwtToken();
			token = jwtToken.getJWTToken(responseService.getResponse());
			
			httpHeaders = new HttpHeaders();
			httpHeaders.set(PrintMessage.HEADER, token);
			
			return new ResponseEntity<>(responseService, httpHeaders, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(responseService, HttpStatus.PRECONDITION_REQUIRED);
	}
	
	@GetMapping("/api/1.0/customer/{customerId}/get")
	public ResponseEntity<CustomerVo> getCustomer(@PathVariable String customerId){
		
		CustomerVo customerVo = null;
		
		customerVo = iGetCustomerServices.getCustomerById(customerId);
		
		return new ResponseEntity<>(customerVo, HttpStatus.OK);
		
		
		
		
		
	}
}
