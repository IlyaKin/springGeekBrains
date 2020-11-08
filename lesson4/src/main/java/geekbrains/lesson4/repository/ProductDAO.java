package geekbrains.lesson4.repository;

import geekbrains.lesson4.domain.ProductinShop;
import org.springframework.stereotype.Repository;


import java.util.List;

public interface ProductDAO {
    List<ProductinShop> findAll();
    ProductinShop findById(Long id);
    ProductinShop findmaxPrice();
    ProductinShop findminPrice();
    void save(ProductinShop product);
    void update(ProductinShop product);
    void delete(ProductinShop author);
    void deletebyId(Long id);
}

