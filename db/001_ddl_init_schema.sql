/*the script deletes entity if it exists
and creates it again*/

drop table if exists posts;
drop table if exists authorities;
drop table if exists users;


create table if not exists posts
(
    id          serial primary key,
    name        varchar(2000),
    description text,
    created     timestamp without time zone not null default now()
);

CREATE TABLE if not exists users
(
    id       serial primary key,
    username VARCHAR(50)  unique NOT NULL,
    password VARCHAR(100) NOT NULL,
    enabled  boolean default true
);

CREATE TABLE if not exists authorities
(
    id        serial primary key,
    username  VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    users_id  int references users (id)
);
