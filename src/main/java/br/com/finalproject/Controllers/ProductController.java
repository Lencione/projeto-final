package br.com.finalproject.Controllers;

import br.com.finalproject.Dto.Response;
import br.com.finalproject.Services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<Response> getAll(){
        return ResponseEntity.ok().body(new Response("success", "Products retrieved successfully", productService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getById(@PathVariable Long id){
        try {
            return ResponseEntity.ok().body(new Response("success", "Product retrieved with success!",productService.getById(id)));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new Response(
                    "error",
                    e.getMessage(),
                    null
            ));
        }


    }
}
