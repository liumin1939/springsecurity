INSERT INTO USER_INFO(user_name,password)  VALUES('liumin','$2a$10$E69CmFi1SipN0bXLUu46n./0m1IgF7A.6ukPOq6ORA7BSanxI5wA.'),('admin','$2a$10$E69CmFi1SipN0bXLUu46n./0m1IgF7A.6ukPOq6ORA7BSanxI5wA.');
INSERT INTO ROLE_INFO(role_name)  VALUES('ROLE_USER'),('ROLE_ADMIN');
INSERT INTO USER_ROLE_RELATION(user_id,role_id) values (1,1),(2,1),(2,2);
INSERT INTO sys_menu(menu_name,menu_url) values ('用户查询','/user/getUserByName'),('管理员查询','/admin/getUserByName');
INSERT INTO sys_role_menu(role_id,menu_id) values (1,1),(2,1),(2,2);
