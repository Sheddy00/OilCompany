package hei.school.oilcompany.controller;


import hei.school.oilcompany.db.entity.GasStation;
import hei.school.oilcompany.service.GasStationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/GasStations")
@AllArgsConstructor
public class GasStationController {
    GasStationService gasStationService;

    @GetMapping({"", "/"})
    public List<GasStation> getAllGasStations() {
        return gasStationService.findAll();
    }

    @GetMapping("/{id}")
    public GasStation getGasStationById(@PathVariable("id") String id) {
        return gasStationService.findById(id);
    }

    @GetMapping({"/ok"})
    public String yes(){
        return "successfuly";
    }

}
