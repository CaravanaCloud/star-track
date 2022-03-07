package startrack.api.rs;

import startrack.api.entity.TenantEntity;
import startrack.api.service.PersonService;
import startrack.model.Person;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Path("/{tenant}")
public class TenantResource {
    @Inject
    Instance<PersonService> personService;

    @Path("/person")
    public PersonResource getPersonResource(
            @PathParam("tenant") String tenantCode) {
        return findTenant(tenantCode)
                .map(tenant -> new PersonResource(
                        personService.get(),
                        tenant))
                .orElseThrow(notFound("Could not find tenant [%s]".formatted(tenantCode)));
    }

    private Supplier<WebApplicationException> notFound(String msg) {
        return () -> new WebApplicationException(msg,404);
    }

    private Optional<TenantEntity> findTenant(String tenantCode) {
        var tenant = (TenantEntity) TenantEntity
                .find("code", tenantCode)
                .firstResult();
        return Optional.ofNullable(tenant);
    }
}
