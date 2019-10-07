package at.leonschloemmer.rest;

import at.leonschloemmer.business.ChapterRepository;
import at.leonschloemmer.entities.Chapter;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("chapters")
public class ChapterEndpoint {

    @Inject
    ChapterRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Counted(name = "cntAllRead")
    @Timed(name = "readAllTimer", unit = MetricUnits.MILLISECONDS, description = "How long it takes to read all from the database")
    @Retry(maxRetries = 3, delay = 100)
    public List<Chapter> allChapters() {
        return repository.getAllChapters();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Timed(name = "createNewTimer", unit = MetricUnits.MILLISECONDS, description = "How long it takes to get revision dates from DatesService")
    public Response createNew(@QueryParam("name") String name) {
        Chapter c = repository.createNewChapter(name);
        return Response.ok().entity(c).build();
    }

}
