package startrack.api.rs;

import startrack.api.entity.PersonEntity;
import startrack.api.entity.TenantEntity;
import startrack.api.service.PersonService;
import startrack.model.Person;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static javax.ws.rs.core.MediaType.*;

public class PersonResource {

    private PersonService personService;
    private TenantEntity tenant;

    public PersonResource(){}

    public PersonResource(
            PersonService personService,
            TenantEntity tenant) {
        this.personService = personService;
        this.tenant = tenant;
    }

    @GET
    @Produces(APPLICATION_JSON)
    public List<Person> getAll(){
        return personService.listAll();
    }

    @GET
    @Path("/{uuid}")
    @Produces(APPLICATION_JSON)
    public Person findByUUID(@PathParam("uuid") String uuid){
        return personService.findByUUID(uuid);
    }


}
