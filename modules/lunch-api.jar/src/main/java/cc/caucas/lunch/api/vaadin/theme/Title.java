package cc.caucas.lunch.api.vaadin.theme;

import com.vaadin.ui.Label;

/**
 * @author Georgy Davityan.
 */
public class Title extends Label {

    public Title(String content) {
        super(content);
        setPrimaryStyleName(LunchTheme.StyleName.TITLE);
    }

    public Title() {
        this("");
    }
}
