package startrack.api.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.Type;
import startrack.model.Person;

import javax.persistence.*;
import java.util.Map;
import java.util.UUID;

@Entity(name = "Users")
@Table(name = "users")
public class UserEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    UUID uuid;

    @ManyToOne
    TenantEntity tenant;

    String username;

    String authServerId;

    @ElementCollection
    @CollectionTable(name = "users_properties_map",
            joinColumns = {
                    @JoinColumn(name = "users_uuid",
                            referencedColumnName = "uuid")})
    @MapKeyColumn(name = "property_key")
    @Column(name = "property_value")
    Map<String, String> properties;

}