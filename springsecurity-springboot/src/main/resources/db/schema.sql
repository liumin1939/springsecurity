create table user_info (
 id int not  null primary key auto_increment ,
 user_name varchar(30),
 password varchar(60),
 insert_time timestamp default current_timestamp ,
 update_time timestamp default current_timestamp
);

create table role_info (
 id int not  null primary key auto_increment ,
 role_name varchar(100),
 insert_time timestamp default current_timestamp ,
 update_time timestamp default current_timestamp
);

create table user_role_relation (
 id int not  null primary key auto_increment ,
 user_id int not null,
 role_id int,
 insert_time timestamp default current_timestamp ,
 update_time timestamp default current_timestamp
);

create table sys_menu (
 id int not  null primary key auto_increment ,
 menu_name varchar (60) not null,
 menu_url varchar (120) not null,
 insert_time timestamp default current_timestamp ,
 update_time timestamp default current_timestamp
);

create table sys_role_menu (
 id int not  null primary key auto_increment ,
 role_id int not null,
 menu_id int,
 insert_time timestamp default current_timestamp ,
 update_time timestamp default current_timestamp
);