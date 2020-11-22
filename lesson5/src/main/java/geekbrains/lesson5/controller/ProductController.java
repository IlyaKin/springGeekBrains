package geekbrains.lesson5.controller;

import geekbrains.lesson5.domain.ProductinShop;
import geekbrains.lesson5.domain.Role;
import geekbrains.lesson5.domain.User;
import geekbrains.lesson5.service.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @GetMapping()
    public String list(Model model){
        List<ProductinShop> products = productService.getAll();
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ProductinShop getProduct (@PathVariable Long id){
        return productService.getById(id);
    }

    @GetMapping(params = {"idparam","titleparam", "priceparam"})
    public String updateBD(Model model,
                           @RequestParam(name = "idparam") Long idparam,
                           @RequestParam (name = "titleparam")String titleparam,
                           @RequestParam (name = "priceparam")double priceparam){
        ProductinShop product = new ProductinShop(idparam,titleparam,priceparam);
        List<ProductinShop> productinShops =  productService.update(product);
        model.addAttribute("products", productinShops);
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


    @GetMapping("/filter")
    public String getFormFilter(){
        return "filter";
    }

    // http://localhost:8080/app/products/new - GET
    @GetMapping("/new")
    public String getFormNewProduct(Model model) {
        model.addAttribute("product", new ProductinShop());
        return "new-product";
    }

    @GetMapping("/edit")
    public String getFormEdit(Model model){
            List<ProductinShop> products = productService.getAll();
            model.addAttribute("products", products);
            return "edit_page";
    }

   // http://localhost:8080/app/products/new - POST
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addNewProduct(ProductinShop product){
        productService.save(product);
        return "redirect:/products";
    }

    // http://localhost:8080/myapp/products?from=35.4&to=3
    @GetMapping(params = {"from", "to"})
    public String productsByPrice(Model model,
                                  @RequestParam(name = "from") double from,
                                  @RequestParam double to){
        List<ProductinShop> products = productService.getByPrice(from, to);
        model.addAttribute("products", products);
        return "list";
    }
}
