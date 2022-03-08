package startrack.app.auth;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

@Dependent
public class AuthClientHeaders implements ClientHeadersFactory {
    @Inject
    JsonWebToken accessToken;

    @Override
    public MultivaluedMap<String, String> update(
            MultivaluedMap<String, String> incomingHeaders,
            MultivaluedMap<String, String> clientOutgoingHeaders) {
        var token = "Bearer " + accessToken.getRawToken();
        return new MultivaluedHashMap<>() {{
            add("Authorization", token);
        }};
    }
}