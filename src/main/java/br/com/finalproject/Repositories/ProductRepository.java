package br.com.finalproject.Repositories;

import br.com.finalproject.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product getProductById(Long id);
    List<Product> getProductsByName(String name);


}
