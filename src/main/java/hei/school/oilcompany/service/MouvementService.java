package hei.school.oilcompany.service;

import hei.school.oilcompany.db.entity.Mouvement;
import hei.school.oilcompany.operation.MouvementOperation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MouvementService {
    MouvementOperation mouvementOperation;

    public List<Mouvement> findAll() { return mouvementOperation.findAll(); }

    public Mouvement findById(String id) {
        return mouvementOperation.getById(id);
    }

    public Mouvement save(Mouvement mouvement) {
        return mouvementOperation.save(mouvement);
    }
}
