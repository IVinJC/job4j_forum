drop table if exists posts;

create table if not exists posts (
                       id serial primary key,
                       name varchar(2000),
                       description text,
                       created timestamp without time zone not null default now()
);

insert into posts (name, description, created) values ('Продажа машины',
'Продаю машину ВАЗ 2109 1987 года серого цвета, не битая, не крашенная))))',
'2022-03-02 18:14:10');
insert into posts (name, description, created) values ('Пропала собака',
                                                       'Пропала собака по кличке Шарик',
                                                       '2022-03-02 18:14:10');

insert into posts (name, description, created) values ('Прогноз погоды на завтра',
                                                       'Ожидаются местами осадки, температура воздуха 24 градуса',
                                                       '2022-03-02 18:14:10');