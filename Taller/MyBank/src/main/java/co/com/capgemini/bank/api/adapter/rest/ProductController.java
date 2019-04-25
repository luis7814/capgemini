package co.com.capgemini.bank.api.adapter.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.capgemini.bank.core.commons.entities.ProductVo;
import co.com.capgemini.bank.core.shared.services.IGetProductListService;

/*
 * Clase : ProductController.java
 * Comentario : Clase que se encarga de gestionar los servicios Rest Product
 * 
 */

@RestController
public class ProductController {

	@Autowired
	private IGetProductListService iGetProductListService;
	
	@GetMapping("/api/1.0/product/get")
	public ResponseEntity<List<ProductVo>> getProductList(){
		
		List<ProductVo> productVos = null;
		
		productVos = iGetProductListService.getProductList();
		
		return new ResponseEntity<List<ProductVo>>(productVos, HttpStatus.OK);
		
	}
}
