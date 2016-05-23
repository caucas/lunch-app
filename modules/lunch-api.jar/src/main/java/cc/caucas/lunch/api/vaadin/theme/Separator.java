package cc.caucas.lunch.api.vaadin.theme;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;

/**
 * @author Georgy Davityan.
 */
public class Separator extends Label {

    public Separator() {
        super("<hr/>", ContentMode.HTML);
        setPrimaryStyleName(LunchTheme.StyleName.SEPARATOR);
    }

}