package startrack.api.rs;

import startrack.api.entity.TenantEntity;
import startrack.api.service.InterviewService;
import startrack.api.service.PersonService;
import startrack.model.InterviewEvent;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

public class InterviewResource {
    private TenantEntity tenant;
    private InterviewService interviewService;

    public InterviewResource(TenantEntity tenant,
                             InterviewService interviewService) {
        this.tenant = tenant;
        this.interviewService = interviewService;
    }

    @GET
    @Path("{uuid}")
    @Produces(APPLICATION_JSON)
    public InterviewEvent getInterview(@PathParam("uuid") String uuid) {
        return interviewService.findByUUID(uuid);
    }
}
