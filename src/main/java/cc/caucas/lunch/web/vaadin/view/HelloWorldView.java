package cc.caucas.lunch.web.vaadin.view;

import cc.caucas.lunch.web.vaadin.common.ViewDetails;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;

import javax.annotation.PostConstruct;

/**
 * @author Georgy Davityan.
 */
@UIScope
@SpringView(name = HelloWorldView.NAME)
public class HelloWorldView extends Panel implements View, ViewDetails {

    public static final String NAME = "helloworld";

    @PostConstruct
    void init() {
        Button button = new Button("HelloWorld");
        button.addClickListener(event -> Notification.show("Hello, World!!!"));
        setContent(button);
    }

    @Override
    public String getNavigation() {
        return NAME;
    }

    @Override
    public String getViewName() {
        return "HelloWorld";
    }

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public String getViewTitle() {
        return "Welcome to Jamaica!";
    }

    @Override
    public Resource getViewIcon() {
        return FontAwesome.WORDPRESS;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
    }
}
