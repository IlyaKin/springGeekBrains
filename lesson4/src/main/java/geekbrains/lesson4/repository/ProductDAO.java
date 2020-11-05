package geekbrains.lesson4.repository;

import geekbrains.lesson4.shoples4.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAll();
    Product findById(Long id);
    void save(Product title, Product price);
    void update(Product title, Product price);
    void delete(Product author);
}

