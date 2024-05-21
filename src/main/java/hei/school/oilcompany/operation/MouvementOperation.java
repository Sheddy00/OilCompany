package hei.school.oilcompany.operation;

import hei.school.oilcompany.db.entity.Mouvement;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Repository
@AllArgsConstructor
public class MouvementOperation extends AutoCrud<Mouvement, String>{

    @Override
    protected String getTableName() {
        return "mouvement";
    }

    @Override
    protected Mouvement mapResultSetToEntity(ResultSet resultSet) {
        try {
            Mouvement mouvement = new Mouvement();
            mouvement.setId(resultSet.getString("id"));
            mouvement.setDate(resultSet.getDate("dateTime").toLocalDate());
            mouvement.setType(resultSet.getString("type"));
            mouvement.setQuantity(resultSet.getDouble("quantity"));
            mouvement.setProduct(resultSet.getInt("product"));
            mouvement.setGasStation(resultSet.getInt("gasStation"));
            return mouvement;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
