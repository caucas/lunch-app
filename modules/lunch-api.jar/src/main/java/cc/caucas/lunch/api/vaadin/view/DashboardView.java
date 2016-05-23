package cc.caucas.lunch.api.vaadin.view;

import cc.caucas.lunch.api.vaadin.common.ViewDetails;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * @author Georgy Davityan.
 */
@UIScope
@SpringView(name = DashboardView.NAME)
public class DashboardView extends VerticalLayout implements View, ViewDetails {

    public static final String NAME = "";

    @PostConstruct
    void init() {
        addComponent(new Label("Content"));
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
        return "Dashboard";
    }

    @Override
    public String getViewTitle() {
        return "Lunch Application Dashboard";
    }

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public Resource getViewIcon() {
        return FontAwesome.DASHBOARD;
    }
}
