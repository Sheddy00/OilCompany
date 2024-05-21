package hei.school.oilcompany.service;

import hei.school.oilcompany.db.entity.Product;
import hei.school.oilcompany.db.entity.ProductPrice;
import hei.school.oilcompany.operation.ProductPriceOperation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductPriceService {
    ProductPriceOperation productPriceOperation;

    public List<ProductPrice> findAll() {
        return productPriceOperation.findAll();
    }

    public ProductPrice findById(String id) {
        return productPriceOperation.getById(Integer.valueOf(id));
    }

    public ProductPrice save(ProductPrice productPrice) {
        return productPriceOperation.save(productPrice);
    }

}
