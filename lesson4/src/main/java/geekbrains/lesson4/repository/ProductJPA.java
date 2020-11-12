package geekbrains.lesson4.repository;

import geekbrains.lesson4.domain.ProductinShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductJPA extends JpaRepository<ProductinShop, Long> {
    List<ProductinShop> findAll ();
    ProductinShop findAllById(Long id);

    @Query(value = "select p from ProductinShop p where p.price = (select max(p.price) from p)", nativeQuery = false)
    ProductinShop findMaximum();

    @Query(value = "select p from ProductinShop p where p.price = (select min(p.price) from p)", nativeQuery = false)
    ProductinShop  findMinimum();

    @Modifying
    @Query(value = "insert into productsinshop  (price, title) values (:price, :title)", nativeQuery = true)
    @Transactional
    void saveProduct(@Param("title") String title, @Param("price") Double price);



}
