package hei.school.oilcompany.service;

import hei.school.oilcompany.db.entity.Product;
import hei.school.oilcompany.operation.ProductOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductOperation productOperation;

    public List<Product> findAll(){
        return productOperation.findAll();
    }

    public Product findById(String id) {
        return productOperation.getById(Integer.valueOf(id));
    }

    public Product save(Product product) {
        return productOperation.save(product);
    }

    public Product delete(String id) { return productOperation.deleteById(Integer.valueOf(id)); }
}
