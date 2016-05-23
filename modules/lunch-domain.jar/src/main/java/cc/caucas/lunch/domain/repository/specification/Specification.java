package cc.caucas.lunch.domain.repository.specification;

import java.util.List;

/**
 * @author Georgy Davityan.
 */
public interface Specification<T> {

    List<T> executeQuery();

}
