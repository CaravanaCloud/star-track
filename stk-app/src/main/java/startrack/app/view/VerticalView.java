package startrack.app.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import startrack.app.vaadin.TranslationProvider;

import java.util.Locale;

public class VerticalView extends VerticalLayout {
    TranslationProvider tx = new TranslationProvider();

    public String translate(String key, Object... args) {
        return tx.getTranslation(key, getLocale(), args);
    }
}
