package at.leonschloemmer.rest;

import at.leonschloemmer.business.ChapterRepository;
import at.leonschloemmer.entities.Chapter;

import javax.inject.Inject;
import javax.json.JsonObject;
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
    public List<Chapter> allChapters() {
        return repository.getAllChapters();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
//    @Path("{name}")
    public Response createNew(@QueryParam("name") String name) {
        System.out.println(name);
        Chapter c = repository.createNewChapter(name);
        return Response.ok().entity(repository.createNewChapter(name)).build();
    }

}
