package hei.school.oilcompany.operation;

import hei.school.oilcompany.db.entity.Stock;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Repository
public class StockOperation extends AutoCrud<Stock, Integer>{
    @Override
    protected String getTableName() {
        return "stock";
    }

    @Override
    protected Stock mapResultSetToEntity(ResultSet resultSet) {
        try {
            Stock stock = new Stock();
            stock.setId(resultSet.getString("id"));
            stock.setEvaporationRate(resultSet.getDouble("evaporationRate"));
            stock.setDateTime(LocalDateTime.from(resultSet.getDate("dateTime").toLocalDate()));
            stock.setQuantity(resultSet.getDouble("quantity"));
            stock.setIdProduct(resultSet.getInt("idProduct"));
            stock.setIdGasStation(resultSet.getInt("idGasStation"));
            return stock;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
