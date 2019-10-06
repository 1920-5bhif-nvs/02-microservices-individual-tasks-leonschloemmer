package at.leonschloemmer.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Chapter.findAll", query = "select c from Chapter c")
})
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "chapter_id")
    private List<RevisionDate> dates;

    public Chapter() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RevisionDate> getDates() {
        return dates;
    }

    public void setDates(List<RevisionDate> dates) {
        this.dates = dates;
    }
}
