package pl.haladyj.ss15_ex1_RS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.haladyj.ss15_ex1_RS.entity.Product;
import pl.haladyj.ss15_ex1_RS.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/id/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
        Optional<Product> productOpt = productService.findProductById(id);

        if(productOpt.isPresent()){
            return ResponseEntity.ok(productOpt.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/product/name/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable("name") String name){
        Optional<Product> productOpt = productService.findProductByName(name);

        if(productOpt.isPresent()){
            return ResponseEntity.ok(productOpt.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> products = productService.findAll();
        return ResponseEntity.ok(products);
    }
}
