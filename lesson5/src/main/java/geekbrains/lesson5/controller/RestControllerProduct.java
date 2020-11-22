package geekbrains.lesson5.controller;

import geekbrains.lesson5.domain.ProductinShop;
import geekbrains.lesson5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/restProducts")
@RestController

public class RestControllerProduct {
    private ProductService productService;

    @Autowired
    public void ProductService(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public List<ProductinShop> allProducts() {
        return productService.getAll();
    }


    @GetMapping("/{id}")
    public ProductinShop getProduct(@PathVariable Long id) {
        return productService.getById(id);
    }


    @RequestMapping(value = "/page_{id}", method = RequestMethod.GET)
    public List<ProductinShop> getByPages(Model model, @PathVariable("id") int id) {
      return productService.getByPages(id);

    }
}


