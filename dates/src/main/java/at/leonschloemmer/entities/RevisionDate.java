package at.leonschloemmer.entities;

import java.time.LocalDate;

public class RevisionDate {

    private int revisionOrder;
    private LocalDate revisionDate;

    public RevisionDate(int revisionOrder, LocalDate revisionDate) {
        this.revisionDate = revisionDate;
        this.revisionOrder = revisionOrder;
    }

    public int getRevisionOrder() {
        return revisionOrder;
    }

    public void setRevisionOrder(int revisionOrder) {
        this.revisionOrder = revisionOrder;
    }

    public LocalDate getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(LocalDate revisionDate) {
        this.revisionDate = revisionDate;
    }
}
