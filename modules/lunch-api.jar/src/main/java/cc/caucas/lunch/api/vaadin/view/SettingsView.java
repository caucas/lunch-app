package cc.caucas.lunch.api.vaadin.view;

import cc.caucas.lunch.api.vaadin.common.ViewDetails;
import cc.caucas.lunch.api.vaadin.theme.LunchTheme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

/**
 * @author Georgy Davityan.
 */
@UIScope
@SpringView(name = SettingsView.NAME)
public class SettingsView extends CustomComponent implements View, ViewDetails {

    public static final String NAME = "settings";

    @PostConstruct
    void init() {
        setCompositionRoot(new VerticalLayout() {
            {
                addComponent(new Panel("Security") {
                    {
                        setPrimaryStyleName(LunchTheme.StyleName.PANEL);
                        setSizeUndefined();
                        setContent(new VerticalLayout(){
                            {
                                setSizeUndefined();
                                addComponent(new TextField() {
                                    {
                                        setPrimaryStyleName(LunchTheme.StyleName.TEXT_FIELD);
                                        setInputPrompt("Username");
                                        setIcon(FontAwesome.USER);
                                    }
                                });
                                addComponent(new TextField() {
                                    {
                                        setPrimaryStyleName(LunchTheme.StyleName.TEXT_FIELD);
                                        setInputPrompt("Password");
                                        setIcon(FontAwesome.KEY);
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });
    }

    @Override
    public String getNavigation() {
        return NAME;
    }

    @Override
    public String getViewName() {
        return "Settings";
    }

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public String getViewTitle() {
        return "Application Settings";
    }

    @Override
    public Resource getViewIcon() {
        return FontAwesome.COGS;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
    }
}
