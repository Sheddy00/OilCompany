package hei.school.oilcompany.operation;

import java.util.List;

public interface CrudOperation<D, ID> {
    List<D> findAll();
    D getById(ID id);
    D save(D toSave);
}
