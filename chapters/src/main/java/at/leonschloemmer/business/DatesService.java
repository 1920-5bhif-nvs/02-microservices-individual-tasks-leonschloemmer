package at.leonschloemmer.business;

import at.leonschloemmer.entities.RevisionDate;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("dates")
@RegisterRestClient
public interface DatesService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<RevisionDate> getDates();

}
