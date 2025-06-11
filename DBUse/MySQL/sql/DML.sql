use note;

insert into test1 values (2,'username2','password2');

insert into test1(id,username,password) set id = 4, username = 'username4',password = 'password4';



-- 删除
delete  from test1;
truncate table test1  -- 速度快，但是无法回滚  自增会从1开始重新开始