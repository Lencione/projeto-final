package br.com.finalproject.Services;

import br.com.finalproject.Entities.Product;
import br.com.finalproject.Repositories.ProductRepository;
import net.bytebuddy.implementation.bytecode.Throw;
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
        Product product = productRepository.getProductById(id);

        if(product == null){
            throw new RuntimeException("Product doesn't exists!");
        }
        return product;
    }

    public List<Product> getAll(){
        return productRepository.findAll();
    }
}
