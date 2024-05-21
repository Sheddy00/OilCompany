package hei.school.oilcompany.controller;

import hei.school.oilcompany.db.entity.ProductPrice;
import hei.school.oilcompany.service.ProductPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/ProductPrice"})
public class ProductPriceController {

    @Autowired
    ProductPriceService productPriceService;

    @GetMapping({"", "/"})
    public List<ProductPrice> getAllProductPrice() {
        return productPriceService.findAll();
    }

    @GetMapping("/{id}")
    public ProductPrice getProductPriceById(@PathVariable("id") String id) {
        return productPriceService.findById(id);
    }

    @DeleteMapping("delete/{id}")
    public ProductPrice deleteStationById(@PathVariable("id") String id) { return productPriceService.delete(id); }

    @PostMapping("/saveProductPrice")
    public ProductPrice saveProduct(@RequestBody ProductPrice productprice) { return productPriceService.save(productprice); }

}
