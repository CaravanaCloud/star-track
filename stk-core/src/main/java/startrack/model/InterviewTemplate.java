package startrack.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public class InterviewTemplate {
    @Id
    @GeneratedValue
    UUID uuid;
    String templateName;
    InterviewEvent interviewEvent;
}
