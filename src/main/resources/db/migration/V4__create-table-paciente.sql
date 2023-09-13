create table pacientes
(
    id           bigint       not null auto_increment,
    name         varchar(100) not null,
    email        varchar(100) not null unique,
    docIdentify  varchar(14)  not null unique,
    phone        varchar(20)  not null,
    street       varchar(100) not null,
    distrito     varchar(100) not null,
    complement   varchar(100) not null,
    number       varchar(20)  not null,
    city         varchar(100) not null,
    codigoPostal varchar(9)   not null,
    primary key (id)
);