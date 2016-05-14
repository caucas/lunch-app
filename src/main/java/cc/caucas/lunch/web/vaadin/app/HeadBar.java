package cc.caucas.lunch.web.vaadin.app;

import cc.caucas.lunch.web.vaadin.theme.FlatButton;
import cc.caucas.lunch.web.vaadin.theme.LunchTheme;
import com.vaadin.ui.HorizontalLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Georgy Davityan.
 */
public class HeadBar extends HorizontalLayout {

    private List<SignOutClickListener> listeners = new ArrayList<>();

    public HeadBar() {
        setId(LunchTheme.Id.APPLICATION_BAR);
        FlatButton signOutButton = new FlatButton("Sign Out");
        signOutButton.addClickListener(event ->
                listeners.forEach(SignOutClickListener::onSignOutClick));
        addComponent(signOutButton);
    }

    public interface SignOutClickListener {
        void onSignOutClick();
    }

    public void addSignOutClickListener(SignOutClickListener listener) {
        listeners.add(listener);
    }
}
