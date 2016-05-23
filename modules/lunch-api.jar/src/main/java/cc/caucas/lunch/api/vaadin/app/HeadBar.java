package cc.caucas.lunch.api.vaadin.app;

import cc.caucas.lunch.api.vaadin.theme.LunchTheme;
import cc.caucas.lunch.api.vaadin.theme.FlatButton;
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
