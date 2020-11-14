package geekbrains.lesson5.repository;

import geekbrains.lesson5.domain.ProductinShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


public interface ProductDAO extends JpaRepository<ProductinShop, Long> {
    List<ProductinShop> findAllByPriceBetween(Double startPrice, Double endPrice);

    @Query(value = "select p from ProductinShop p where p.id > 5*(:id-1) and p.id <= 5*:id", nativeQuery = false)
    List<ProductinShop> findByPages(@Param("id") int id);

    @Modifying
    @Query(value = "update ProductinShop SET price = :price, title = :title where id = :id", nativeQuery = false)
    @Transactional
    void update(@Param("id") Long id, @Param("title") String title, @Param("price") double price);
}


