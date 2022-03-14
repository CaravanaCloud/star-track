package startrack.api.service;

import io.quarkus.security.identity.SecurityIdentity;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.Map;

@Dependent
public class UserService {
    @Inject
    KeycloakService keycloak;

    @Inject
    SecurityIdentity securityIdentity;

    @Inject
    JsonWebToken jwtToken;


    public Map<String, String> whoami() {
        return Map.of(
                "username", getUsername(),
                "id", keycloak.getUserId(getUsername()),
                "keycloak_ping", keycloak.ping(),
                "jwtToken", getShortToken()
        );
    }

    private String getShortToken() {
        return jwtToken.getRawToken().substring(0, 10) + "...";
    }

    private String getUsername() {
        return securityIdentity.getPrincipal().getName();
    }




}
