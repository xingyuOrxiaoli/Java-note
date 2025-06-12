
use note;

select * from test1 cross join test3;   -- 笛卡尔集 有左右之分

-- 自然链接 natural join   默认匹配所有的同名列
select * from test1 natural join test3;

-- using 需要同名
select * from test1 join test3 using(id);

-- on
select * from test1 join test3 on (test1.id = test3.test1Id);

select * from test1 join test3 on (test1.id = test3.test1Id) where test1.id = 1;

select * from test1 left join test3 on (test1.id = test3.test1Id)
union all -- all 表示不去重
select * from test1 right join test3 on (test1.id = test3.test1Id);


-- 不相关 查询test1.id 大于test2.id任意一个的数据
select * from test1 where id > any(select test2.id from test2); -- 多行

select * from test1 where id > (select min(test2.id) from test2);  -- 单行

-- 所有

select * from test1 where id > all(select test2.id from test2); -- 多行

select * from test1 where id > (select max(test2.id) from test2);  -- 单行


-- 相关子查询  子查询不可以独立运行

select * from test1 where id = (select max(test1.id) from test1);  -- 单行