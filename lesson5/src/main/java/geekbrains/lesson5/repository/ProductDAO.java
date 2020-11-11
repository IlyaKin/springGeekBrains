package geekbrains.lesson5.repository;

import geekbrains.lesson5.domain.ProductinShop;

import java.util.List;

public interface ProductDAO {
    List<ProductinShop> findAll();
    List<ProductinShop> findByPages(int id);
    ProductinShop findById(Long id);
    ProductinShop findmaxPrice();
    ProductinShop findminPrice();
    void save(ProductinShop product);
    List<ProductinShop> update(ProductinShop productinShop);
    void delete(ProductinShop author);
    void deletebyId(Long id);
}

