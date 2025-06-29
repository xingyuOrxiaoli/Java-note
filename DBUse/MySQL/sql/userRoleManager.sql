use mysql;


-- 角色管理 MySQL8 新增的功能
-- 创建角色role
create role 'role1' , 'role2';

-- 给角色分配权限

grant select on `note`.* to 'role1';
grant update , delete , insert on `note`.* to 'role2';

select * from mysql.user;

-- 给用户分配角色
grant 'role1' to `user1`@`%`;
grant 'role2' to `user2`@`localhost`;
-- 激活角色
set default role all to `user1`@`%` ,  `user2`@`localhost`;


-- 给用户撤销角色

revoke 'role1' from `user1`@`%`;
revoke 'role2' from `user2`@`localhost`;

-- 删除角色
drop role 'role1'@`%`;
