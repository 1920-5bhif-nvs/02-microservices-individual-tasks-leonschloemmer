package at.leonschloemmer.business;

import at.leonschloemmer.entities.Chapter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ChapterRepository {

    @Inject
    EntityManager em;

    @Inject
    DatesCommunicator com;

    /**
     * Get all chapters in database
     * @return List of all persisted chapters
     */
    public List<Chapter> getAllChapters() {
        TypedQuery<Chapter> query = em.createNamedQuery("Chapter.findAll", Chapter.class);
        List<Chapter> result = query.getResultList();
        return result;
    }

    /**
     * Create a new chapter and persist in database.
     * Also creates all initial revision dates
     * @param name the name of the chapter to be created
     * @return The created chapter with the dates
     */
    @Transactional
    public Chapter createNewChapter(String name) {
//        throw new NotImplementedException();
        Chapter newChapter = new Chapter();
        newChapter.setName(name);

        newChapter.setDates(com.getDates());

        em.persist(newChapter);

        return newChapter;
    }

}
