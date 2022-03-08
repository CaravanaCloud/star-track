create table interview_event (tenant_uuid varchar(255),
    uuid varchar(255) not null,
    endTime datetime(6),
    startTime datetime(6),
    primary key (uuid));

alter table interview_event
    add constraint interview_event_tenant
    foreign key (tenant_uuid) references tenant (uuid);


create table interview_participant (uuid varchar(255) not null,
    interviewRole varchar(255),
    interviewEvent_uuid varchar(255),
    person_uuid varchar(255), primary key (uuid));

alter table interview_participant
    add constraint participant_event
    foreign key (interviewEvent_uuid)
    references interview_event (uuid);

alter table interview_participant
    add constraint participant_person
    foreign key (person_uuid)
    references person (uuid);

create table interview_question (uuid varchar(255) not null, statement TEXT, interview_uuid varchar(255), primary key (uuid)) engine=InnoDB;
alter table interview_question add constraint question_interview foreign key (interview_uuid) references interview_event (uuid);
