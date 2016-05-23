package cc.caucas.lunch.data.repository.spring.specification;

import cc.caucas.lunch.domain.model.Account;
import cc.caucas.lunch.domain.repository.specification.AccountSpecification;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * @author Georgy Davityan.
 */
public class AccountByLoginSpecification implements AccountSpecification, MongoSpecification {

    private MongoOperations mongoOperations;

    private String login;

    public AccountByLoginSpecification(String login) {
        this.login = login;
    }

    @Override
    public void setMongoOperations(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public List<Account> executeQuery() {
        Query query = Query.query(Criteria.where("login").is(login));
        return mongoOperations.find(query, Account.class);
    }
}
