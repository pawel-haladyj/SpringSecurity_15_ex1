package pl.haladyj.ss15_ex1_RS.service;

import pl.haladyj.ss15_ex1_RS.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public Optional<Product> findProductById(Long id);
    public Optional<Product> findProductByName(String name);
    public List<Product> findAll();

}
