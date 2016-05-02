package cc.caucas.lunch.web.vaadin.app;

import cc.caucas.lunch.web.vaadin.theme.LunchTheme;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.MenuBar;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Georgy Davityan.
 */
public class HeadBar extends HorizontalLayout {

    private List<SignOutClickListener> listeners = new ArrayList<>();

    public HeadBar() {
        setId(LunchTheme.Id.APPLICATION_BAR);

        MenuBar menu = new MenuBar();
        menu.setStyleName("lunch-headbar-menu");
        MenuBar.MenuItem menuItem = menu.addItem("John Smith", null);
        menuItem.addItem("Sign Out", item -> listeners.forEach(SignOutClickListener::onSignOutClick));
        addComponent(menu);
    }

    public interface SignOutClickListener {
        void onSignOutClick();
    }

    public void addSignOutClickListener(SignOutClickListener listener) {
        listeners.add(listener);
    }
}
