package hei.school.oilcompany.controller;

import hei.school.oilcompany.db.entity.Product;
import hei.school.oilcompany.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("delete/{id}")
    public Product deleteStationById(@PathVariable("id") String id) { return productService.delete(id); }

    @PostMapping("/saveProduct")
    public Product saveProduct(@RequestBody Product product) { return productService.save(product); }

}
