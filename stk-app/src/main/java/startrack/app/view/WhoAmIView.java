package startrack.app.view;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import startrack.app.client.WhoAmIClient;

import javax.inject.Inject;

@Route("user/whoami")
public class WhoAmIView extends VerticalLayout {
    @Inject
    public WhoAmIView(@RestClient WhoAmIClient whoAmIService) {
        add(new Label("Hello " + whoAmIService.whoami()));
    }
}
