package startrack.api.service;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.UserRepresentation;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class KeycloakService {
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

    @ConfigProperty(name = "quarkus.oidc.client-id")
    String userClientId;

    @ConfigProperty(name = "quarkus.oidc.client-secret")
    String userClientSecret;

    @Inject
    UserService userService;

    public void createUser() {
        var users = users();
        var user = newUserRepresentation();
        users.create(user);
    }

    private UserRepresentation newUserRepresentation() {
        var user = new UserRepresentation();
        user.setEnabled(true);
        user.setUsername("tester-"+System.currentTimeMillis());
        user.setFirstName("First");
        user.setLastName("Last");
        user.setEmail("tom+tester1@caravana.cloud");
        user.setAttributes(Map.of("origin", List.of("demo")));
        return user;
    }

    public String ping() {
        return "notpong";
    }

    private Keycloak userClient() {
        var kc = KeycloakBuilder.builder()
                .serverUrl(adminUrl)
                .realm(realmName)
                .username(adminUsername)
                .password(adminPassword)
                .clientId(userClientId)
                .clientSecret(userClientSecret)
                .build();
        return kc;
    }

    private Keycloak adminClient() {
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

    private RealmResource userRealm(){
        return userClient().realm(realmName);
    }

    private RealmResource adminRealm() {
        return adminClient().realm(realmName);
    }

    private UsersResource users(){
        return adminRealm().users();
    }

    public String getUserId(String username){
        var first = 0;
        var max = 1;
        var search = users().search(username, first, max);
        var user = search.get(0);
        return user.getId();
    }

    private void deleteUser(String userId) {
        users().delete(userId);
    }



}
