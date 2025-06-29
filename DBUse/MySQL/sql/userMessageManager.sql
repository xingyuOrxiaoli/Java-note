use mysql;


select * from mysql.user;

-- 创建用户
create user `user1`  identified by 'xiaoli';

create user `用户名`@`主机名` identified by '密码';

create user `user2`@`localhost` identified by 'password2';


create user `user3`@`192.168.100.%` identified by 'password3';
create user `user3`@`localhost` identified by 'password3';
create user `user3`@`%` identified by 'password3';

--  Host % 表示可以在任意主机登录

-- 修改用户
alter user `user1`@`%` identified by 'password1';

-- 删除用户

drop user 'user3';
-- 上下两个等价，默认删除Host为%的
drop user `user3`@ `%`;


-- 修改安全插件  mysql8默认的为：caching_sha2_password
-- 修改成        mysql_native_password   可以让一些软件登录
alter user `user1`@`%` identified with mysql_native_password  by 'password1';





