package hei.school.oilcompany.operation;

import hei.school.oilcompany.db.entity.Product;
import hei.school.oilcompany.db.entity.ProductPrice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@AllArgsConstructor
public class ProductOperation extends AutoCrud<Product, Integer>{

    @Override
    protected String getTableName() {
        return "product";
    }

    @Override
    protected Product mapResultSetToEntity(ResultSet resultSet) {
        try {
            Product product = new Product();
            product.setId(resultSet.getString("id"));
            product.setName(resultSet.getString("productname"));
            product.setPrice(resultSet.getDouble("productprice"));
            return product;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
