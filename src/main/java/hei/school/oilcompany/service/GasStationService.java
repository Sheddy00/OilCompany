package hei.school.oilcompany.service;

import hei.school.oilcompany.db.entity.GasStation;
import hei.school.oilcompany.operation.GasStationOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GasStationService {

    @Autowired
    GasStationOperation gasStationOperation;

    public List<GasStation> findAll(){
        return gasStationOperation.findAll();
    }

    public GasStation findById(String id) {
        return gasStationOperation.getById(id);
    }

    public GasStation save(GasStation gasStation) {
        return gasStationOperation.save(gasStation);
    }

    public GasStation delete(String id) { return gasStationOperation.deleteById(id); }
}
