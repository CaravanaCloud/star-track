package startrack.app.view;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ClientCallable;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.UUID;

/**
 * The main view contains a button and a click listener.
 */
@Route("hello")
public class HelloView extends VerticalLayout {
    static final Logger log = LoggerFactory.getLogger(HelloView.class);
    public HelloView() {
        // Use TextField for standard text input
        TextField textField = new TextField("Your name");
        textField.addThemeName("bordered");

        // Button click listeners can be defined as lambda expressions
        Button button = new Button("Say hello",
                e -> onClick(e, textField));

        // Theme variants give you predefined extra styles for components.
        // Example: Primary button is more prominent look.
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        // You can specify keyboard shortcuts for buttons.
        // Example: Pressing enter in this view clicks the Button.
        button.addClickShortcut(Key.ENTER);

        // Use custom CSS classes to apply styling. This is defined in shared-styles.css.
        addClassName("centered-content");
        
        add(textField, button);
    }

    @PostConstruct
    private void postConstruct(){
        intiLocalStorage();
        invokeJSfromJava();
    }

    private void intiLocalStorage() {
        var uuid = UUID.randomUUID().toString();
        var page = UI.getCurrent().getPage();
        page.executeJs("console.log($0)", uuid);
    }

    @ClientCallable
    public void invokeJavaFromJS(){
        Notification.show("Invoked from JS");
    }

    public void invokeJSfromJava() {
        var page = UI.getCurrent().getPage();
        page.executeJs("$0.$server.invokeJavaFromJS();", getElement());
    }



    private void onClick(ClickEvent<Button> e, TextField textField) {
        var msg = "Hello "+textField.getValue();
        Notification.show(msg);
    }
}
