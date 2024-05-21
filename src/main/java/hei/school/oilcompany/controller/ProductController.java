package hei.school.oilcompany.controller;

import hei.school.oilcompany.db.entity.Product;
import hei.school.oilcompany.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/Products"})
public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping({"", "/"})
    public List<Product> getAllProduct() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") String id) {
        return productService.findById(id);
    }

    @GetMapping({"/ok"})
    public String yes(){
        return "successfuly";
    }
}
