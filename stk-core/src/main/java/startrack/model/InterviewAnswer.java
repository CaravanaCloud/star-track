package startrack.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@MappedSuperclass
public class InterviewAnswer {
    @Id
    @GeneratedValue
    UUID uuid;
    InterviewQuestion question;
    String answer;
}
