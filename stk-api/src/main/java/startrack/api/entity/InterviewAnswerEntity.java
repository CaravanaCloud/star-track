package startrack.api.entity;

import org.hibernate.annotations.Type;
import startrack.model.InterviewEvent;
import startrack.model.InterviewSection;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

public class InterviewAnswerEntity {
    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    UUID uuid;

    @ManyToOne
    InterviewEventEntity interview;

    @ManyToOne
    InteviewQuestionEntity section;

    @Column(columnDefinition = "TEXT")
    String answer;
}
