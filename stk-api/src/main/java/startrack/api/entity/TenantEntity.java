package startrack.api.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity(name = "Tenant")
@Table(name = "tenant")
public class TenantEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    UUID uuid;
    String code;
}
