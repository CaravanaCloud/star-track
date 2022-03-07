package startrack.util;

import java.util.UUID;

public abstract class Utils {
    static final String generateUUID() {
        return UUID.randomUUID().toString();
    }
}
