create table users(
    uuid varchar(255) not null,
    authServerId varchar(255),
    username varchar(255),
    tenant_uuid varchar(255),
    primary key (uuid));

create table users_properties_map(
    users_uuid varchar(255) not null,
    property_value varchar(255),
    property_key varchar(255) not null,
    primary key (users_uuid, property_key));

alter table users
    add constraint users_tenant
    foreign key (tenant_uuid) references tenant (uuid);

alter table users_properties_map
    add constraint users_properties
    foreign key (users_uuid) references users(uuid);