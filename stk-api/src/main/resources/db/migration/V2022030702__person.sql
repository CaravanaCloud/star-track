create table person (tenant_uuid varchar(255) not null,
    uuid varchar(255) not null,
    fullName varchar(255),
    primary key (uuid));

alter table person
    add constraint fk_tenant
    foreign key (tenant_uuid)
    references tenant (uuid);
