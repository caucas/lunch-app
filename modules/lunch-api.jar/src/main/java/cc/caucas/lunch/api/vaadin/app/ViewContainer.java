package cc.caucas.lunch.api.vaadin.app;

import cc.caucas.lunch.api.vaadin.theme.LunchTheme;
import com.vaadin.ui.CssLayout;

/**
 * @author Georgy Davityan.
 */
public class ViewContainer extends CssLayout {

    public ViewContainer() {
        setId(LunchTheme.Id.APPLICATION_CONTENT);
        setSizeFull();
    }
}
