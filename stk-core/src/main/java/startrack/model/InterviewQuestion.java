package startrack.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public class InterviewQuestion {
    @Id
    @GeneratedValue
    UUID uuid;
    InterviewSection section;
    String statement;

    public InterviewQuestion() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public InterviewSection getSection() {
        return section;
    }

    public void setSection(InterviewSection section) {
        this.section = section;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }
}
