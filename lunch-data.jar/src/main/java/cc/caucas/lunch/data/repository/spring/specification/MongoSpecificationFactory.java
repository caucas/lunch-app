package cc.caucas.lunch.data.repository.spring.specification;

import cc.caucas.lunch.domain.repository.specification.Specification;
import cc.caucas.lunch.domain.repository.specification.SpecificationFactory;
import cc.caucas.lunch.domain.repository.specification.SpecificationFactoryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

/**
 * @author Georgy Davityan.
 */
@Component
public class MongoSpecificationFactory implements SpecificationFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoSpecificationFactory.class);

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public <T extends Specification> T createSpecification(Class<T> specificationClass) {
        if (!specificationClass.isAssignableFrom(MongoSpecification.class)) {
            throw new IllegalArgumentException("The specification class must implement " + MongoSpecification.class);
        }

        try {
            MongoSpecification specification = (MongoSpecification) specificationClass.newInstance();
            specification.setMongoOperations(mongoOperations);
            return (T) specification;
        } catch (ReflectiveOperationException e) {
            LOGGER.error("Can't create specification instance!", e);

            throw new SpecificationFactoryException("Can't create specification instance!", e);
        }
    }

    @Override
    public <T extends Specification> T createSpecification(Class<T> specificationClass,
                                                           SpecificationInstantiator<T> instantiator) {
        if (!MongoSpecification.class.isAssignableFrom(specificationClass)) {
            throw new IllegalArgumentException("The specification class must implement " + MongoSpecification.class);
        }

        MongoSpecification specification = (MongoSpecification) instantiator.instantiate();
        specification.setMongoOperations(mongoOperations);

        return (T) specification;
    }

}
