package startrack.api.service;

import startrack.api.entity.InterviewEventEntity;
import startrack.model.InterviewEvent;

import javax.enterprise.context.Dependent;

@Dependent
public class InterviewService extends Service{

    public InterviewEvent findByUUID(String uuid) {
        return findByUUID(InterviewEventEntity.class, uuid)
                .map(InterviewEventEntity::toInterviewEvent)
                .get();
    }

}
