package cc.caucas.lunch.web.vaadin.theme;

import com.vaadin.ui.Button;

/**
 * @author Georgy Davityan.
 */
public class FlatButton extends Button {

    public FlatButton(String caption) {
        super(caption);
        setPrimaryStyleName(LunchTheme.StyleName.FLAT_BUTTON);
    }

    public FlatButton() {
        this("");
    }
}
