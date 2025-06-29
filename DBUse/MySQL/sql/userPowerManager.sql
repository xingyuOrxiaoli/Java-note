use mysql;

-- 查询权限
show grants;  -- 当前用户的权限

show grants for `user1`; -- USAGE除了登录什么都做不到

-- 分配权限 1

-- 表note的所有权限
grant all on `note`.* to `user1`@`%`;

-- 撤销权限 1
revoke all on `note`.* from `user1`@`%`;


-- 分配权限 2
grant select, update , delete ,insert on `note`.* to `user1`@`%`;

-- 撤销权限 2

revoke delete on `note`.* from `user1`@`%`;


-- 刷新权限
flush privileges;