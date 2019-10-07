package at.leonschloemmer.business;

import at.leonschloemmer.entities.RevisionDate;
import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class DatesCommunicator {

    @ConfigProperty(name = "datescommunicator.url")
    String url;

    private Client client;
    private WebTarget target;

    public void onStart(@Observes StartupEvent event) {
        client = ClientBuilder.newClient();
        target = client.target(url);
    }

    public List<RevisionDate> getDates() {
        Response response = target.request(MediaType.APPLICATION_JSON).get();
        JsonArray jsonDates = response.readEntity(JsonArray.class);
        List<RevisionDate> dates = new LinkedList<>();
        for(int i = 0; i < jsonDates.size(); i++) {
            JsonObject jsRevisionDate = jsonDates.getJsonObject(i);
            RevisionDate revisionDate = new RevisionDate();
            revisionDate.setRevisionDate(LocalDate.parse(jsRevisionDate.getString("revisionDate")));
            revisionDate.setRevisionOrder(jsRevisionDate.getInt("revisionOrder"));
            dates.add(revisionDate);
        }
        return dates;
    }

}
