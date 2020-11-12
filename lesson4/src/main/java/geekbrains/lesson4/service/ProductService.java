package geekbrains.lesson4.service;

import geekbrains.lesson4.domain.ProductinShop;
import geekbrains.lesson4.repository.ProductJPA;
import org.springframework.stereotype.Service;


import java.util.Comparator;
import java.util.List;

@Service
public class ProductService {

    //private ProductRepo productRepo;
   // private final ProductImplDAO productImplDAO;
    private ProductJPA productJPA;

    /*public ProductService(ProductImplDAO productImplDAO) {
        this.productImplDAO = productImplDAO;
    }*/

    public ProductService(ProductJPA productJPA){this.productJPA=productJPA;}

   public ProductinShop getById(Long id){
        return productJPA.findAllById(id);
    }

    public List<ProductinShop> getAll(){
        List<ProductinShop> products = productJPA.findAll();
        products.sort(Comparator.comparingLong(ProductinShop::getId));
        return products;
    }

    public ProductinShop getmaxPrice(){
        return productJPA.findMaximum();
    }

    public ProductinShop getminPrice(){
        return productJPA.findMinimum();
    }

   /* public List<ProductinShop> getByPrice(Double start, Double end){
        return productImplDAO.findAll().stream()
                .filter(product-> product.getPrice() >= start && product.getPrice() <= end)
                .sorted(Comparator.comparingDouble(ProductinShop::getPrice))
                .collect(Collectors.toList());
    }*/

    public void save(ProductinShop product){
         productJPA.saveProduct(product.getTitle(), product.getPrice());
    }
/*
    public void removeById(Long id){
        productImplDAO.deletebyId(id);
    }*/

}
