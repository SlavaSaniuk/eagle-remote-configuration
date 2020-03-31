package by.bsac.services;

import org.springframework.transaction.annotation.Transactional;

public interface CrudService<E, I> {

    @Transactional
    E create(E entity);

    E getById(I id);
}
