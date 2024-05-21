package hei.school.oilcompany.controller;

import hei.school.oilcompany.db.entity.ProductPrice;
import hei.school.oilcompany.service.ProductPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
