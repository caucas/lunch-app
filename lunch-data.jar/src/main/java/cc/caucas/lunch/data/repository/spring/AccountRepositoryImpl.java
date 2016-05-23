package cc.caucas.lunch.data.repository.spring;

import cc.caucas.lunch.domain.model.Account;
import cc.caucas.lunch.domain.repository.AccountRepository;
import cc.caucas.lunch.domain.repository.specification.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Georgy Davityan.
 */
@Component
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public void add(Account model) {
        mongoOperations.insert(model);
    }

    @Override
    public void remove(Account model) {
        mongoOperations.remove(model);
    }

    @Override
    public void update(Account model) {
        mongoOperations.save(model);
    }

    @Override
    public List<Account> query(Specification<Account> specification) {
        return specification.executeQuery();
    }

}
