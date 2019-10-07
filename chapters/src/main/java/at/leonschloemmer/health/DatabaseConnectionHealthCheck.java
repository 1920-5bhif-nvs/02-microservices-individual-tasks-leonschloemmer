package at.leonschloemmer.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.ResultSet;
import java.util.List;

@Readiness
@ApplicationScoped
public class DatabaseConnectionHealthCheck implements HealthCheck {

    @Inject
    EntityManager em;

    @Override
    public HealthCheckResponse call() {
        HealthCheckResponseBuilder response = HealthCheckResponse.named("Database Connection Health");

        try {
            Query query = em.createNativeQuery("select 1");
            List<Integer> result = query.getResultList();
            if (result == null || result.size() == 0) {
                response.down();
            } else {
                response.up();
            }
        } catch (Exception e) {
            response.down();
        }

        return response.build();
    }

}
