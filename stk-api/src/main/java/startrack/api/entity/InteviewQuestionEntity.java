package startrack.api.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "InterviewQuestion")
@Table(name="interview_question")
public class InteviewQuestionEntity {
    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    UUID uuid;

    @Column(columnDefinition="TEXT")
    String statement;

    @ManyToOne
    InterviewEventEntity interview;
}
