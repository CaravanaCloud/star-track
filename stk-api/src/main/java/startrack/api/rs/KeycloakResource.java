package startrack.api.rs;

import org.slf4j.Logger;
import startrack.api.service.KeycloakService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/dev/keycloak")
public class KeycloakResource {
    @Inject
    Logger log;

    @Inject
    KeycloakService keycloak;

    @Path("createUser")
    @GET
    public void getCreateUser() {
        log.info("createUser");
        keycloak.createUser();
        return ;
    }
}
