package hei.school.oilcompany.operation;

import hei.school.oilcompany.db.entity.Product;
import hei.school.oilcompany.db.entity.ProductPrice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Repository
@AllArgsConstructor
public class ProductPriceOperation extends AutoCrud<ProductPrice, Integer>{
    @Override
    protected String getTableName() {
        return "productPrice";
    }

    @Override
    protected ProductPrice mapResultSetToEntity(ResultSet resultSet) {
        try {
            ProductPrice productPrice = new ProductPrice();
            productPrice.setId(resultSet.getString("id"));
            productPrice.setUnitPrice(resultSet.getDouble("price"));
            productPrice.setDate(LocalDateTime.from(resultSet.getDate("dateTime").toLocalDate()));
            return productPrice;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
