package pl.haladyj.ss15_ex1_RS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.haladyj.ss15_ex1_RS.entity.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findProductById(Long id);
    Optional<Product> findProductByName(String name);
    List<Product> findAll();
}
