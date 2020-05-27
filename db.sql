drop table if exists user;
create table user (
    id int(11) auto_increment,
    username varchar(32) not null,
    password varchar(64) not null,
    nickname varchar(32) not null,
    created_time datetime default current_timestamp,
    updated_time datetime default current_timestamp on update current_timestamp,
    primary key (id),
    unique key (username)
);