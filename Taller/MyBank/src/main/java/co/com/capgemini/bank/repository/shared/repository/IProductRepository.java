package co.com.capgemini.bank.repository.shared.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.capgemini.bank.repository.commons.entities.Product;

public interface IProductRepository extends JpaRepository<Product, Long>{

}
