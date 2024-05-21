package hei.school.oilcompany.controller;

import hei.school.oilcompany.db.entity.Mouvement;
import hei.school.oilcompany.service.MouvementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
