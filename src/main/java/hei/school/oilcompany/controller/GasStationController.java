package hei.school.oilcompany.controller;


import hei.school.oilcompany.db.entity.GasStation;
import hei.school.oilcompany.service.GasStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/GasStations")
public class GasStationController {

    @Autowired
    GasStationService gasStationService;

    @GetMapping({"", "/"})
    public List<GasStation> getAllGasStations() {
        return gasStationService.findAll();
    }

    @GetMapping("/{id}")
    public GasStation getGasStationById(@PathVariable("id") String id) {
        return gasStationService.findById(id);
    }

    @DeleteMapping("delete/{id}")
    public GasStation deleteStationById(@PathVariable("id") String id) { return gasStationService.delete(id); }

    @PostMapping("/saveStation")
    public GasStation saveStaion(@RequestBody GasStation gasStation) { return gasStationService.save(gasStation); }

}
