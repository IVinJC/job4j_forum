/*the script fills the table*/

insert into posts (name, description, created) values ('Продажа машины',
'Продаю машину ВАЗ 2109 1987 года серого цвета, не битая, не крашенная))))',
'2022-03-02 18:14:10');
insert into posts (name, description, created) values ('Пропала собака',
                                                       'Пропала собака по кличке Шарик',
                                                       '2022-03-02 18:14:10');

insert into posts (name, description, created) values ('Прогноз погоды на завтра',
                                                       'Ожидаются местами осадки, температура воздуха 24 градуса',
                                                       '2022-03-02 18:14:10');

insert into users(username, password, enabled) values ('user1', 'user1', 'true');
insert into authorities (username, authority, users_id) values ('user', 'user', 1);
insert into authorities (username, authority, users_id) values ('user', 'admin', 1);