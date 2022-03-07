package startrack.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public class InterviewSection {
    @Id
    @GeneratedValue
    UUID uuid;
    String sectionName;
    @ManyToOne
    InterviewEvent interview;
}
