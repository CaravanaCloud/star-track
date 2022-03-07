package startrack.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public class InterviewEvent {
    @Id
    @GeneratedValue
    UUID uuid;
    LocalDateTime startTime;
    LocalDateTime endTime;
}
