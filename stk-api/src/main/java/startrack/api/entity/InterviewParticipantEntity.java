package startrack.api.entity;

import org.hibernate.annotations.Type;
import startrack.model.InterviewRole;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "InterviewParticipant")
@Table(name="interview_participant")
public class InterviewParticipantEntity {
    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    UUID uuid;

    @ManyToOne
    PersonEntity person;

    @ManyToOne
    InterviewEventEntity interviewEvent;

    @Enumerated(EnumType.STRING)
    InterviewRole interviewRole;
}
