package cc.caucas.lunch.data.repository.spring;

import cc.caucas.lunch.domain.model.Customer;
import cc.caucas.lunch.domain.repository.CustomerRepository;
import cc.caucas.lunch.domain.repository.specification.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Georgy Davityan.
 */
@Component
public class CustomerRepositoryImpl implements CustomerRepository {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void add(Customer model) {
        mongoOperations.insert(model);
    }

    @Override
    public void remove(Customer model) {
        mongoOperations.remove(model);
    }

    @Override
    public void update(Customer model) {
        mongoOperations.save(model);
    }

    @Override
    public List<Customer> query(Specification<Customer> specification) {
        return null;
    }

}
