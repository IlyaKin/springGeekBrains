package geekbrains.lesson5.service;

import geekbrains.lesson5.domain.ProductinShop;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public interface ProductService {
    List<ProductinShop> getAll();

    ProductinShop getById(Long id);

    ProductinShop save(ProductinShop product);

    List<ProductinShop> getByPrice(double priceFrom, double priceTo);

    List<ProductinShop> update(ProductinShop product);

    List<ProductinShop> getByPages(int id);
}

