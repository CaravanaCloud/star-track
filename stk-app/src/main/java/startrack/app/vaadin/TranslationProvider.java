package startrack.app.vaadin;

import com.vaadin.flow.i18n.I18NProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class TranslationProvider implements I18NProvider {
    private static final Logger log = LoggerFactory.getLogger(TranslationProvider.class);
    private static final List<Locale> locales = Stream
            .of("pt", "es")
            .map(Locale::forLanguageTag)
            .toList();
    public static final String BUNDLE_NAME = "startrack";

    @Override
    public List<Locale> getProvidedLocales() {
        return locales;
    }

    @Override
    public String   getTranslation(String key,
                                 Locale locale,
                                 Object... params) {
        var bundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);
        if (! bundle.containsKey(key)) {
            bundle = ResourceBundle.getBundle(BUNDLE_NAME);
            if (! bundle.containsKey(key)) {
                log.info("missing resource key (i18n) " + key);
                return key + " - " + locale;
            }
        }
        var value = bundle.getString(key);
        if (params.length > 0) {
            return MessageFormat.format(value, params);
        } else {
            return value;
        }
    }


}
