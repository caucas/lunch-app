package cc.caucas.lunch.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Georgy Davityan.
 */
@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {}
