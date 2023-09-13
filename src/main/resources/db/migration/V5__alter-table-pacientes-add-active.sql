alter table pacientes add column active tinyint;
update pacientes set active = 1;
alter table pacientes modify active tinyint not null;