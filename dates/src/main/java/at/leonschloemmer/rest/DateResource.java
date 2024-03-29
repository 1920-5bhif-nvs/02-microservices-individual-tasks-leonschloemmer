package at.leonschloemmer.rest;

import at.leonschloemmer.business.DateGenerator;
import at.leonschloemmer.entities.RevisionDate;
import org.eclipse.microprofile.metrics.annotation.Counted;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("dates")
public class DateResource {

    @Inject
    DateGenerator generator;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Counted(name = "cntGetDates")
    public List<RevisionDate> getDates() {
        return generator.getDatesStartingToday();
    }

}
