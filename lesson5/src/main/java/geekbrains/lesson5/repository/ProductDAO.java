package geekbrains.lesson5.repository;

import geekbrains.lesson5.domain.ProductinShop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductDAO extends JpaRepository<ProductinShop, Long> {
    List<ProductinShop> findAllByPriceBetween(Double startPrice, Double endPrice);
}


