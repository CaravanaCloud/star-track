package startrack.api.entity;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity(name = "InterviewQuestion")
@Table(name="interview_question")
public class InteviewQuestionEntity {
    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    UUID uuid;
}
