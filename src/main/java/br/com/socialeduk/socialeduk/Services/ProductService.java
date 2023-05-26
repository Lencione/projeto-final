package br.com.socialeduk.socialeduk.Services;

import br.com.socialeduk.socialeduk.Entities.Product;
import br.com.socialeduk.socialeduk.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductsByName(String name){
        return productRepository.getProductsByName(name);
    }

    public Product getById(Long id){
        return  productRepository.getProductById(id);
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }
}
