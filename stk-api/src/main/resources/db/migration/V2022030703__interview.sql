create table interview_event (tenant_uuid varchar(255),
    uuid varchar(255) not null,
    endTime datetime(6),
    startTime datetime(6),
    primary key (uuid));

alter table interview_event
    add constraint interview_event_tenant
    foreign key (tenant_uuid) references tenant (uuid);
