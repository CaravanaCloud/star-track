package startrack.api.service;

import startrack.api.entity.InterviewEventEntity;
import startrack.api.entity.TenantEntity;
import startrack.model.InterviewEvent;

import javax.enterprise.context.Dependent;

@Dependent
public class InterviewService extends Service{

    public InterviewEvent findByUUID(TenantEntity tenant, String uuid) {
        //TODO: Check tentant
        return findByUUID(InterviewEventEntity.class, uuid)
                .map(InterviewEventEntity::toInterviewEvent)
                .get();
    }

}
