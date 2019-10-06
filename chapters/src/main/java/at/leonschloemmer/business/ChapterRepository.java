package at.leonschloemmer.business;

import at.leonschloemmer.entities.Chapter;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ChapterRepository {

    @Inject
    EntityManager em;

    /**
     * Get all chapters in database
     * @return List of all persisted chapters
     */
    public List<Chapter> getAllChapters() {
        throw new NotImplementedException();
    }

    /**
     * Create a new chapter and persist in database.
     * Also creates all initial revision dates
     * @param name the name of the chapter to be created
     * @return
     */
    public Chapter createNewChapter(String name) {
        throw new NotImplementedException();
    }

}
