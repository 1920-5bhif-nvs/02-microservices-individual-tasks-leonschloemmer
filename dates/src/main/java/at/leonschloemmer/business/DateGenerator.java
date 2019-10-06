package at.leonschloemmer.business;

import at.leonschloemmer.entities.RevisionDate;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class DateGenerator {

    public List<RevisionDate> getDatesStartingToday() {
        List<RevisionDate> dates = new LinkedList<>();
        for(int i = 0; i < 3; i++) {
            if (i == 0) {
                dates.add(new RevisionDate(i, LocalDate.now()));
            } else {
                dates.add((new RevisionDate(i, dates.get(i - 1).getRevisionDate().plusDays(1 * i))));
            }
        }
        return dates;
    }

}
