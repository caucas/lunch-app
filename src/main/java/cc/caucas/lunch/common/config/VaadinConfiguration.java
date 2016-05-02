package cc.caucas.lunch.common.config;

import cc.caucas.lunch.web.vaadin.common.ViewDetailsProvider;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Georgy Davityan.
 */
@Configuration
@Import(com.vaadin.spring.VaadinConfiguration.class)
public class VaadinConfiguration implements ApplicationContextAware, BeanDefinitionRegistryPostProcessor {

    private ApplicationContext applicationContext;
    private BeanDefinitionRegistry beanDefinitionRegistry;

    @Bean
    public ViewDetailsProvider viewProvider() {
        return new ViewDetailsProvider(applicationContext, beanDefinitionRegistry);
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry)
            throws BeansException {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory)
            throws BeansException {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
