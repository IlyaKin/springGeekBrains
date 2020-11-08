package geekbrains.lesson5.controller;

import geekbrains.lesson5.domain.ProductinShop;
import geekbrains.lesson5.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // http://localhost:8080/myapp/products - GET
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model){
        List<ProductinShop> products = productService.getAll();
        model.addAttribute("products", products);
        return "list";
    }

    @RequestMapping(value = "/page_{id}", method = RequestMethod.GET)
            public String getByPages(Model model,@PathVariable("id") int id){
        List<ProductinShop> products = productService.getByPages(id);
        model.addAttribute("products", products);
        model.addAttribute("page", id);
        model.addAttribute("next", id+1);
        model.addAttribute("back", id-1);
        return "pages";
    }



    // http://localhost:8080/app/products/1 - GET
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getById(Model model,@PathVariable("id") Long id){
        ProductinShop byId = productService.getById(id);
        model.addAttribute("products",
                byId == null ? new ProductinShop(): byId);
        return "products";
    }
    @RequestMapping("/max")
    public String getmaxPrice(Model model){
        ProductinShop product = productService.getmaxPrice();
        model.addAttribute("products", product);
        return "products";
    }
    @RequestMapping("/min")
    public String getminPrice(Model model){
        ProductinShop product = productService.getminPrice();
        model.addAttribute("products", product);
        return "products";
    }

    // http://localhost:8080/app/products/1/price - GET
    @RequestMapping(value = "/{id}/price", method = RequestMethod.GET)
    @ResponseBody
    public String apiPrice(@PathVariable Long id){
        ProductinShop byId = productService.getById(id);
        return String.valueOf(byId == null ? null : byId.getPrice());
    }

    // http://localhost:8080/app/products/new - GET
    @GetMapping("/new")
    public String getFormNewProduct(Model model){
        model.addAttribute("product", new ProductinShop());
        return "new-product";
    }

   /* // http://localhost:8080/app/products/new - POST
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addNewProduct(ProductinShop product){
        ProductinShop savedProduct = productService.save(product);
        System.out.println(savedProduct);
        return "redirect:/products/" + savedProduct.getId();
    }*/

    // http://localhost:8080/app/products/any
    @RequestMapping(value = "any")
    @ResponseBody
    public String anyRequest(){
        return "any request " + UUID.randomUUID().toString();
    }

    // http://localhost:8080/app/products?price_from=35.4&priceTo=3
    @GetMapping(params = {"price_from", "priceTo"})
    public String productsByPrice(Model model,
                                  @RequestParam(name = "price_from") double priceFrom,
                                  @RequestParam double priceTo){
        List<ProductinShop> products = productService.getByPrice(priceFrom, priceTo);
        model.addAttribute("products", products);
        return "list";
    }

    // http://localhost:8080/app/filter?price_from=35.4&priceTo=3
    @GetMapping("/filter")
    public String filterByPrice(Model model,
                                @RequestParam(name = "price_from") double priceFrom,
                                @RequestParam(required = false) Double priceTo){
        List<ProductinShop> products =
                productService.getByPrice(priceFrom, priceTo == null ? Double.MAX_VALUE : priceTo);
        model.addAttribute("products", products);
        return "list";
    }

    // http://localhost:8080/app/filter {title:"asd"}
    @PostMapping("/filter")
    @ResponseBody
    public String filterByTitle(@RequestParam String title){
        return productService.getAll().stream()
                .filter(product-> product.getTitle().contains(title))
                .map(product -> String.valueOf(product.getId()))
                .collect(Collectors.joining(","));
    }

}
