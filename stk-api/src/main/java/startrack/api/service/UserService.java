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
    @ConfigProperty(name = "keycloak.admin.url")
    String adminUrl;

    @ConfigProperty(name ="application.realm.name")
    String realmName;

    @ConfigProperty(name = "keycloak.admin.username")
    String adminUsername;

    @ConfigProperty(name = "keycloak.admin.password")
    String adminPassword;

    @ConfigProperty(name = "keycloak.admin.realm")
    String adminRealm;

    @ConfigProperty(name = "keycloak.admin.client-id")
    String adminClientId;

    @ConfigProperty(name = "keycloak.admin.client-secret")
    String adminClientSecret;

    @Inject
    SecurityIdentity securityIdentity;

    @Inject
    JsonWebToken jwtToken;


    public Map<String, String> whoami() {
        return Map.of(
                "username", getUsername(),
                "id", getUserId(),
                "authServerUrl", adminUrl,
                "jwtToken", getShortToken()
        );
    }

    private String getShortToken() {
        return jwtToken.getRawToken().substring(0, 10) + "...";
    }

    private String getUsername() {
        return securityIdentity.getPrincipal().getName();
    }

    public String getUserId(){
        var first = 0;
        var max = 1;
        var username = getUsername();
        var search = users().search(username, first, max);
        var user = search.get(0);
        return user.getId();
    }

    private void deleteUser(String userId) {
        users().delete(userId);
    }

    private Keycloak keycloak() {
        var kc = KeycloakBuilder.builder()
                .serverUrl(adminUrl)
                .realm(adminRealm)
                .username(adminUsername)
                .password(adminPassword)
                .clientId(adminClientId)
                .clientSecret(adminClientSecret)
                .build();
        return kc;
    }

    private RealmResource applicationRealm(){
        return keycloak().realm(realmName);
    }

    private UsersResource users(){
        return applicationRealm().users();
    }
}
