package geekbrains.lesson5.service;

import geekbrains.lesson5.domain.ProductinShop;
import geekbrains.lesson5.repository.ProductImplDAO;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    //private ProductRepo productRepo;
    private final ProductImplDAO productImplDAO;

    public ProductService(ProductImplDAO productImplDAO) {
        this.productImplDAO = productImplDAO;
    }

    public ProductinShop getById(Long id){
        return productImplDAO.findById(id);
    }

    public List<ProductinShop> getAll(){
        List<ProductinShop> products = productImplDAO.findAll();
        products.sort(Comparator.comparingLong(ProductinShop::getId));
        return products;
    }
    public List<ProductinShop> getByPages(int id){
        List<ProductinShop> products = productImplDAO.findByPages(id);
        products.sort(Comparator.comparingLong(ProductinShop::getId));
        return products;
    }

    public ProductinShop getmaxPrice(){
        ProductinShop product = productImplDAO.findmaxPrice();
        return product;
    }
    public ProductinShop getminPrice(){
        ProductinShop product = productImplDAO.findminPrice();
        return product;
    }

    public List<ProductinShop> getByPrice(Double start, Double end){
        return productImplDAO.findAll().stream()
                .filter(product-> product.getPrice() >= start && product.getPrice() <= end)
                .sorted(Comparator.comparingDouble(ProductinShop::getPrice))
                .collect(Collectors.toList());
    }

    public void save(ProductinShop product){
         productImplDAO.save(product);
    }

    public void removeById(Long id){
        productImplDAO.deletebyId(id);
    }

}
