package cc.caucas.lunch.api;

import cc.caucas.lunch.api.common.config.VaadinConfiguration;
import cc.caucas.lunch.api.common.config.WebSecurityConfiguration;
import com.google.common.eventbus.EventBus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication

@ComponentScan({
        "cc.caucas.lunch.data.repository.*",
        "cc.caucas.lunch.api.controller"
})

@Import({
        VaadinConfiguration.class,
        WebSecurityConfiguration.class
})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public EventBus eventBus() {
        return new EventBus((e, context) -> e.printStackTrace());
    }

}
