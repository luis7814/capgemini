package co.com.capgemini.bank.core.shared.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.capgemini.bank.core.commons.entities.ProductVo;
import co.com.capgemini.bank.repository.commons.dao.IProductDao;
import co.com.capgemini.bank.repository.commons.entities.Product;

/*
 * Clase : GetProductListService.java
 * Comentario : Obtener una lista de productos bancarios (ahorros, cheques, etc.) 
 */

@Service
public class GetProductListService implements IGetProductListService{

	@Autowired
	private IProductDao iProductDao;
	
	@Override
	public List<ProductVo> getProductList() {
		
		ObjectMapper objectMapper = new ObjectMapper();
		List<ProductVo> productVos = null;
		List<Product> products = null;
		
		try {
			
			products = iProductDao.getProductList();
			
			if(products != null) {
				productVos = objectMapper.convertValue(products, new TypeReference<List<ProductVo>>(){});
			}else {
				productVos = null;
			}
			
		}catch (Exception e) {
			productVos = null;
		}
		
		return productVos;
	}
	
	

}
