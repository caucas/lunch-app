package cc.caucas.lunch.data.repository.spring.specification;

import org.springframework.data.mongodb.core.MongoOperations;

/**
 * @author Georgy Davityan.
 */
public interface MongoSpecification {

    void setMongoOperations(MongoOperations mongoOperations);

}
