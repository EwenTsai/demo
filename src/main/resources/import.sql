#password superadmin commonuser
insert into demo.user (id, created_time, nickname, password, updated_time, username) values (1, '2020-11-03 12:01:04.974000', 'ewen', '$2a$10$11UqPf.pGyO52EOKltrwLu206xJttdtoEK9XwRByo22GvK.7jHC.S', '2020-11-03 12:01:04.974000', 'superadmin');
INSERT INTO demo.user (id, created_time, nickname, password, updated_time, username) VALUES (2, '2020-11-04 02:54:46.139000', '张三', '$2a$10$3K9PpDvVuYjertFiZr.HE.VlNFhA1wG385m8/Bvahs.IupBd1mv1W', '2020-11-04 02:54:46.139000', 'commonuser');

insert into demo.user_role (id, create_time, role_id, create_user, user_id) values (1, '2020-11-03 20:00:56', 1, 'ewen', 1);
insert into demo.user_role (id, create_time, role_id, create_user, user_id) values (2, '2020-11-03 20:00:56', 2, '张三', 2);

insert into demo.role (id, role_code, role_name) values (1, 1, 'admin');
insert into demo.role (id, role_code, role_name) values (2, 2, 'user');
