package cc.caucas.lunch.web.vaadin;

import cc.caucas.lunch.common.event.Event.PostViewChangeEvent;
import cc.caucas.lunch.common.event.Event.UserLogoutEvent;
import cc.caucas.lunch.web.vaadin.app.HeadBar;
import cc.caucas.lunch.web.vaadin.app.SideBar;
import cc.caucas.lunch.web.vaadin.app.ViewContainer;
import cc.caucas.lunch.web.vaadin.common.ViewDetails;
import cc.caucas.lunch.web.vaadin.common.ViewDetailsProvider;
import cc.caucas.lunch.web.vaadin.theme.MenuItem;
import cc.caucas.lunch.web.vaadin.theme.Separator;
import cc.caucas.lunch.web.vaadin.theme.Title;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

/**
 * @author Georgy Davityan.
 */
@Theme("lunch")
@SpringUI(path = "/dashboard")
public class DashboardUI extends UI {

    @Autowired
    private EventBus eventBus;
    @Autowired
    private ViewDetailsProvider provider;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        eventBus.register(this);

        ViewContainer container = new ViewContainer();

        setContent(new VerticalLayout() {
            {
                setSizeFull();
                addComponent(new HeadBar() {
                    {
                        addSignOutClickListener(() -> eventBus.post(new UserLogoutEvent()));
                    }
                });
                HorizontalLayout content = new HorizontalLayout() {
                    {
                        setSizeFull();
                        SideBar sideBar = new SideBar(provider.getAllViewDetails()
                                .stream()
                                .sorted((o1, o2) -> o1.getOrder() - o2.getOrder())
                                .map(view -> new MenuItem(view.getViewName(), view.getViewIcon()) {
                                    {
                                        eventBus.register(this);

                                        addClickListener(event -> getNavigator().navigateTo(view.getNavigation()));
                                    }

                                    @Subscribe
                                    void onPostViewChange(PostViewChangeEvent event) {
                                        removeStyleName("selected");
                                        if (view == event.getView()) {
                                            addStyleName("selected");
                                        }
                                    }
                                }).collect(Collectors.toList()));
                        addComponent(sideBar);
                        VerticalLayout viewLayout = new VerticalLayout() {
                            {
                                setSizeFull();
                                setStyleName("view-layout");
                                addComponent(new Title() {
                                    {
                                        eventBus.register(this);
                                    }

                                    @Subscribe
                                    void onPostViewChange(PostViewChangeEvent event) {
                                        setValue(event.getView().getViewTitle());
                                    }
                                });
                                addComponent(new Separator());
                                addComponent(container);
                                setExpandRatio(container, 1.0f);
                            }
                        };
                        addComponent(viewLayout);
                        setExpandRatio(viewLayout, 1.0f);
                    }
                };
                addComponent(content);
                setExpandRatio(content, 1.0f);
            }
        });

        new Navigator(this, container);

        getNavigator().addProvider(provider);
        getNavigator().addViewChangeListener(new ViewChangeListener() {

            @Override
            public boolean beforeViewChange(ViewChangeEvent event) {
                return true;
            }

            @Override
            public void afterViewChange(ViewChangeEvent event) {
                ViewDetails view = provider.getViewDetails(event.getViewName());
                eventBus.post(new PostViewChangeEvent(view));
            }
        });

    }

    @Subscribe
    public void onUserLogout(UserLogoutEvent event) {
        VaadinSession.getCurrent().close();
        getPage().setLocation("/?logout");
    }

}
