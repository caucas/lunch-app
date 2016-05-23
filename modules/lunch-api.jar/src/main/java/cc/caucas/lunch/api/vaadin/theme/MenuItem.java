package cc.caucas.lunch.api.vaadin.theme;

import com.vaadin.server.Resource;
import com.vaadin.ui.Button;

/**
 * @author Georgy Davityan.
 */
public class MenuItem extends Button {

    public MenuItem(String label, Resource icon) {
        setPrimaryStyleName(LunchTheme.StyleName.MENU_ITEM);
        setIcon(icon);
        setCaption(label);
    }

}
