package co.com.capgemini.bank.api.adapter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.capgemini.bank.core.commons.entities.CustomerVo;
import co.com.capgemini.bank.core.commons.entities.ResponseService;
import co.com.capgemini.bank.core.shared.services.ILoginServices;
import co.com.capgemini.bank.core.shared.services.ISignUpServices;

@RestController
public class CustomerController {

	@Autowired
	private ILoginServices iLoginServices;
	
	@Autowired
	private ISignUpServices iSignUpServices;
	
	private ResponseService responseService;
	
	@PostMapping("/api/1.0/customer/sign-up")
	public ResponseEntity<ResponseService> signUp(@RequestBody CustomerVo customerVo){
		
		responseService = iSignUpServices.insertCustomer(customerVo);
		
		return new ResponseEntity<>(responseService, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<ResponseService> login(@RequestParam String customerId, @RequestParam String password){
		
		responseService = iLoginServices.login(customerId, password);
		
		return new ResponseEntity<>(responseService, HttpStatus.ACCEPTED);
	}
}
