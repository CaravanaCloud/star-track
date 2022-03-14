package startrack.api.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.Type;
import startrack.model.Person;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "Person")
@Table(name = "person")
public class PersonEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    UUID uuid;

    String fullName;

    @ManyToOne
    TenantEntity tenant;

    public Person toPerson() {
        return new Person(uuid, fullName);
    }
}
