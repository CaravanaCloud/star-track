package startrack.api.service;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.Optional;
import java.util.UUID;

public class Service {
    @Inject
    EntityManager em;

    public <T> Optional<T> findByUUID(Class<T> clazz, String uuid) {
        if(uuid == null) throw new RuntimeException("uuid is null");
        var _uuid = UUID.fromString(uuid);
        return Optional.ofNullable(em.find(clazz, _uuid));
    }

}
