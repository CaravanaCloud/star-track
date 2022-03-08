package startrack.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.UUID;

public class InterviewEvent {
    UUID uuid;
    LocalDateTime startTime;
    LocalDateTime endTime;

    public InterviewEvent(UUID uuid, LocalDateTime startTime, LocalDateTime endTime) {
        this.uuid = uuid;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public UUID getUuid() {
        return uuid;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }
}
