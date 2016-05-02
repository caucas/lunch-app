package cc.caucas.lunch.common;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Georgy Davityan.
 */
@Repository
public interface AccountRepository extends MongoRepository<Account, String> {}
