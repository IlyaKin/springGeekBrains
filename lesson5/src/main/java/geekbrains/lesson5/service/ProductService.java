package geekbrains.lesson5.service;

import geekbrains.lesson5.domain.ProductinShop;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    //private ProductRepo productRepo;
    List<ProductinShop> getAll();

    ProductinShop getById(Long id);

    ProductinShop save(ProductinShop product);

    List<ProductinShop> getByPrice(double priceFrom, double priceTo);

    List<ProductinShop> update(ProductinShop product);

    List<ProductinShop> getByPages(int id);
}
