delete from userroles;
delete from roles;
delete from blogs;
delete from projects;
delete from users;

insert into roles (roleid,name) values (1,'user'),(2,'admin');

insert into users(userid,username,password) values (1,'AshenPhoenix','$2a$10$dH2CBudIb76pfBXoqtzQZ.lIerSmzKo1bsE.ThGsfFhTLlrTxZMMy');

insert into userroles(userid,roleid) values(1,2);