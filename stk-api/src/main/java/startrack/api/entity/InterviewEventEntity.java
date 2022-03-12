package startrack.api.entity;

import org.hibernate.annotations.Type;
import startrack.model.InterviewEvent;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "InterviewEvent")
@Table(name="interview_event")
public class InterviewEventEntity {
    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    UUID uuid;

    @ManyToOne
    TenantEntity tenant;

    LocalDateTime startTime;
    LocalDateTime endTime;

    public InterviewEventEntity(){}

    public InterviewEvent toInterviewEvent() {
        return new InterviewEvent(uuid,startTime,endTime);
    }
}
