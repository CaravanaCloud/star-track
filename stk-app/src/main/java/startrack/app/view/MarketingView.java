package startrack.app.view;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import startrack.app.vaadin.TranslationProvider;

import javax.inject.Inject;
import java.util.Locale;

@Route("main")
@PageTitle("Marketing page")
public class MarketingView extends VerticalView {

    public MarketingView() {
        setSizeFull();
        setSpacing(true);
        setPadding(true);

        // This VerticalLayout contains the header, contentDiv and button.
        VerticalLayout layout = new VerticalLayout();
        layout.getStyle().set("padding-left", "20%");
        layout.getStyle().set("padding-right", "20%");
        layout.getStyle().set("background-color", "#F5F5F5");
        layout.getStyle().set("flex-shrink", "0");
        layout.setHeight("50%");
        layout.setWidthFull();
        layout.setSpacing(false);

        H1 header = new H1(translate("stk.hero.title"));
        header.setWidthFull();
        Div contentDiv = new Div();
        contentDiv.setText(translate("stk.hero.content"));
        Button button = new Button(translate("stk.hero.button"),
                new Icon(VaadinIcon.ANGLE_DOUBLE_RIGHT));
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        layout.add(header, contentDiv, button);

        // This HorizontalLayout contains box1, box2 and box3.
        HorizontalLayout container = new HorizontalLayout();
        container.setSpacing(false);
        container.getStyle().set("flex-wrap", "wrap");
        container.setSizeFull();
        container.getStyle().set("padding-left", "20%");
        container.getStyle().set("padding-right", "20%");

        String cardHeader = translate("stk.card1.title");
        String cardContent = translate("stk.card1.content");

        Component card1 = createCard(cardHeader, cardContent);
        Component card2 = createCard(cardHeader, cardContent);
        Component card3 = createCard(cardHeader, cardContent);

        container.add(card1, card2, card3);

        add(layout, container);
    }

    private Component createCard(String cardHeader, String cardContent) {
        VerticalLayout layout = new VerticalLayout();
        layout.setWidth("30%");
        layout.setMinWidth("250px");

        H2 header = new H2(cardHeader);
        Div content = new Div();
        content.setText(cardContent);

        layout.getElement().getStyle().set("flex-grow", "1");
        layout.add(header, content);
        return layout;
    }


}