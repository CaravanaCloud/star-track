package startrack.api.rs;

import io.quarkus.security.identity.SecurityIdentity;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.resteasy.annotations.cache.NoCache;
import startrack.api.service.UserService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.HashMap;
import java.util.Map;

@Path("/user/whoami")
public class WhoAmIResource {
    @Inject
    UserService userService;

    @GET
    @RolesAllowed("user")
    @NoCache
    public Map<String, String> whoami() {
        return userService.whoami();
    }


}