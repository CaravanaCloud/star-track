package startrack.app.client;


import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import startrack.app.auth.AuthClientHeaders;


@RegisterRestClient(configKey = "whoami")
@RegisterClientHeaders(AuthClientHeaders.class)
@Path("/user/whoami")
public interface WhoAmIClient {

    @GET
    String whoami();
}

