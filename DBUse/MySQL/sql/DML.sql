use note;

insert into test1 values (2,'username2','password2');
insert into test1 values (5,'username5','password5');

insert into test1(id,username,password) set id = 4, username = 'username4',password = 'password4';


insert into test3 values (1,1,'用户一号');
insert into test3 values (2,2,'用户二号');
insert into test3 values (3,3,'用户三号');
insert into test3 values (4,1,'小李一号');
insert into test3 values (5,2,'小李二号');
insert into test3 values (6,3,'小李三号');

insert into test3 values (7,4,'小赵一号');

-- 删除
delete  from test1;
truncate table test1  -- 速度快，但是无法回滚  自增会从1开始重新开始