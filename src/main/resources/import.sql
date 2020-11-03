insert into security_demo.user (id, created_time, nickname, password, updated_time, username) values (1, '2020-11-03 12:01:04.974000', 'ewen', '$2a$10$11UqPf.pGyO52EOKltrwLu206xJttdtoEK9XwRByo22GvK.7jHC.S', '2020-11-03 12:01:04.974000', 'superadmin');

insert into security_demo.user_right (id, create_time, right_id, create_user, user_id) values (1, '2020-11-03 20:00:56', 1, 'ewen', 1);

insert into security_demo.rights (right_id, right_code, right_name) values (1, 1, 'admin');
