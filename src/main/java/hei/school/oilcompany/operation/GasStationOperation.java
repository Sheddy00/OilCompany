package hei.school.oilcompany.operation;

import hei.school.oilcompany.db.entity.GasStation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@AllArgsConstructor
public class GasStationOperation extends AutoCrud<GasStation, String>{

    @Override
    protected String getTableName() {
        return "gasStation";
    }

    @Override
    protected GasStation mapResultSetToEntity(ResultSet resultSet) {
        try {
            GasStation gasStation = new GasStation();
            gasStation.setId(resultSet.getString("id"));
            gasStation.setStationName(resultSet.getString("stationName"));
            gasStation.setLocation(resultSet.getString("location"));
            return gasStation;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
