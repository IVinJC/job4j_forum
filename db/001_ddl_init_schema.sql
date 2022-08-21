/*the script deletes the posts entity if it exists
and creates it again*/

drop table if exists posts;

create table if not exists posts (
                                     id serial primary key,
                                     name varchar(2000),
                                     description text,
                                     created timestamp without time zone not null default now()
);