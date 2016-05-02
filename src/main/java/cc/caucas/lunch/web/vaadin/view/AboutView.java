package cc.caucas.lunch.web.vaadin.view;

import cc.caucas.lunch.web.vaadin.common.ViewDetails;
import com.vaadin.navigator.View;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

import static com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

/**
 * @author Georgy Davityan.
 */
@UIScope
@SpringView(name = AboutView.NAME)
public class AboutView extends VerticalLayout implements View, ViewDetails {

    public static final String NAME = "about";

    @PostConstruct
    void init() {
        addComponent(new Label("about"));
        addComponent(new TextArea());
    }

    @Override
    public void enter(ViewChangeEvent event) {

    }

    @Override
    public String getNavigation() {
        return NAME;
    }

    @Override
    public String getViewName() {
        return "About";
    }

    @Override
    public String getViewTitle() {
        return "Lunch Application Information";
    }

    @Override
    public Resource getViewIcon() {
        return FontAwesome.INFO_CIRCLE;
    }

}
