create table medicos(
    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null unique,
    document varchar(6) not null unique,
    espacialidad varchar(100) not null,
    street varchar(100) not null,
    distrito varchar(100) not null,
    complement varchar(100) not null,
    number varchar(20) not null,
    city varchar(100) not null,

    primary key(id)
);