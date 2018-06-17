-- apply changes
create table person (
  person_id                     bigint auto_increment not null,
  name                          varchar(255),
  birth_date                    datetime(6),
  created                       datetime(6) not null,
  updated                       datetime(6) not null,
  constraint pk_person primary key (person_id)
);

