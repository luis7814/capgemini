package co.com.capgemini.bank.repository.commons.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.capgemini.bank.repository.commons.entities.Product;
import co.com.capgemini.bank.repository.shared.repository.IProductRepository;

@Repository
public class ProductDao implements IProductDao{

	@Autowired
	private IProductRepository iProductRepository;
	
	@Override
	public Product getProductoId(Long id) throws Exception {
		
		Product product = null;
		Optional<Product> productOptional = Optional.empty();
		
		productOptional = iProductRepository.findById(id);
		product = productOptional.get();
		
		return product;
	}

	@Override
	public List<Product> getProductList() throws Exception {
		
		List<Product> products = null;
		
		products = iProductRepository.findAll();
		
		return products;
	}

}
