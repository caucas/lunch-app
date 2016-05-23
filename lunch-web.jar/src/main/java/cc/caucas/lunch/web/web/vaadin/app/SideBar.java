package cc.caucas.lunch.web.web.vaadin.app;

import cc.caucas.lunch.web.web.vaadin.theme.LunchTheme;
import cc.caucas.lunch.web.web.vaadin.theme.MenuItem;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Georgy Davityan.
 */
public class SideBar extends CustomComponent {

    private List<ClickListener> listeners = new ArrayList<>();

    public SideBar(List<MenuItem> menuItems) {
        setId(LunchTheme.Id.APPLICATION_SIDEBAR);
        setSizeUndefined();
        setCompositionRoot(new VerticalLayout() {
            {
                setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
                for (MenuItem menuItem : menuItems) {
                    menuItem.addClickListener(event ->
                            onMenuItemClick(((MenuItem) event.getButton())));
                    addComponent(menuItem);
                }
            }
        });
    }

    public void addClickListener(ClickListener listener) {
        listeners.add(listener);
    }

    private void onMenuItemClick(MenuItem item) {
        listeners.forEach(listener-> listener.onClick(new MenuItemClickEvent(item)));
    }

    public interface ClickListener {
        void onClick(MenuItemClickEvent event);
    }

    @Data
    @AllArgsConstructor
    public static class MenuItemClickEvent {
        private MenuItem menuItem;
    }

}
