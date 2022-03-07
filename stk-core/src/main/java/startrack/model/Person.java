package startrack.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

public class Person {
    UUID uuid;
    String name;

    public Person(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public UUID getUUID() {
        return uuid;
    }

    public String getName() {
        return name;
    }
}
