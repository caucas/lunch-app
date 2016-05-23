package cc.caucas.lunch.domain.repository;

import cc.caucas.lunch.domain.repository.specification.Specification;

import java.util.List;

/**
 * @author Georgy Davityan.
 */
public interface BaseRepository<T> {

    void add(T model);
    void remove(T model);
    void update(T model);

    List<T> query(Specification<T> specification);

}
