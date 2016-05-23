package cc.caucas.lunch.api.vaadin.common;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;

/**
 * @author Georgy Davityan.
 */
public interface ViewDetails {

    String getNavigation();
    String getViewName();
    default String getViewTitle() {
        return getViewName();
    }
    default int getOrder() {
        return Integer.MAX_VALUE;
    }
    default Resource getViewIcon() {
        return FontAwesome.COFFEE;
    }

}
