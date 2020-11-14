package geekbrains.lesson5.service;

import geekbrains.lesson5.domain.ProductinShop;
import geekbrains.lesson5.repository.ProductDAO;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ProductImplDAO implements ProductService {

    private final ProductDAO productDAO;

    public ProductImplDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<ProductinShop> getAll() {
        return productDAO.findAll();
    }

    @Override
    public ProductinShop getById(Long id) {
        return productDAO.findById(id).orElse(null);
    }

    @Override
    public ProductinShop save(ProductinShop product) {
        return productDAO.save(product);
    }

    @Override
    public List<ProductinShop> getByPrice(double priceFrom, double priceTo) {
        return productDAO.findAllByPriceBetween(priceFrom, priceTo);
    }

    @Override
    public List<ProductinShop> update(ProductinShop productinShop) {
        productDAO.update(productinShop.getId(), productinShop.getTitle(), productinShop.getPrice());
        return productDAO.findAll();
    }

    @Override
    public List<ProductinShop> getByPages(int id) {
        return productDAO.findByPages(id);
    }

}


