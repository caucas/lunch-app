package cc.caucas.lunch.web.vaadin.common;

import com.vaadin.spring.navigator.SpringViewProvider;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * @author Georgy Davityan.
 */
public class ViewDetailsProvider extends SpringViewProvider {

    private ApplicationContext applicationContext;

    public ViewDetailsProvider(ApplicationContext applicationContext,
                               BeanDefinitionRegistry beanDefinitionRegistry) {
        super(applicationContext, beanDefinitionRegistry);
        this.applicationContext = applicationContext;
    }

    public ViewDetails getViewDetails(String viewName) {
        return applicationContext.getBeansOfType(ViewDetails.class).values()
                .stream()
                .filter(viewDetails -> viewDetails == getView(viewName))
                .findFirst()
                .orElse(null);
    }

    public Collection<ViewDetails> getAllViewDetails() {
        return applicationContext.getBeansOfType(ViewDetails.class).values();
    }

}
