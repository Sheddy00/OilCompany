package hei.school.oilcompany.controller;

import hei.school.oilcompany.db.entity.Mouvement;
import hei.school.oilcompany.service.MouvementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Mouvements")
public class MouvementController {

    @Autowired
    MouvementService mouvementService;

    @GetMapping({"", "/"})
    public List<Mouvement> getAllMouvements() {
        return mouvementService.findAll();
    }

    @GetMapping("/{id}")
    public Mouvement getMouvementById(@PathVariable("id") String id) {
        return mouvementService.findById(id);
    }

    @DeleteMapping("delete/{id}")
    public Mouvement deleteStationById(@PathVariable("id") String id) { return mouvementService.delete(id); }

    @PostMapping("saveMouvement")
    public Mouvement saveMouvement(@RequestBody Mouvement mouvement) { return mouvementService.save(mouvement); }

}
