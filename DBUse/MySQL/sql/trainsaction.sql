
-- 开启事务
start transaction;


-- 手动提交
commit;

-- 回滚
rollback ;


-- 查询事务的隔离级别

select @@transaction_isolation
