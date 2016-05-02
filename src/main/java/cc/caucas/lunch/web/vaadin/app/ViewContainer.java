package cc.caucas.lunch.web.vaadin.app;

import cc.caucas.lunch.web.vaadin.theme.LunchTheme;
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
