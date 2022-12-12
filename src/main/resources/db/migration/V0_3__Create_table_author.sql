create table author
(
    id     serial,
    name varchar,
    birthDate date,
    particularity  varchar,
    hasParticularity bool,
    primary key (id)
);