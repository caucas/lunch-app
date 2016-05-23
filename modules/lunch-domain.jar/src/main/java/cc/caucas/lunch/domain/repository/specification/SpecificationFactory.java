package cc.caucas.lunch.domain.repository.specification;

/**
 * @author Georgy Davityan.
 */
public interface SpecificationFactory {

    <T extends Specification> T createSpecification(Class<T> specificationClass);

    <T extends Specification> T createSpecification(Class<T> specificationClass,
                                                    SpecificationInstantiator<T> instantiator);


    @FunctionalInterface
    interface SpecificationInstantiator<T> {

        T instantiate();

    }
}
