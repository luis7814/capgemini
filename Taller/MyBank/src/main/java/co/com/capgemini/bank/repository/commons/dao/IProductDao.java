package co.com.capgemini.bank.repository.commons.dao;

import java.util.List;

import co.com.capgemini.bank.repository.commons.entities.Product;

public interface IProductDao {
	
	Product getProductoId(Long id) throws Exception;
	List<Product> getProductList() throws Exception;
}
