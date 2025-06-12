

-- 获取所有数据 是否有索引作用不大
select * from test1;

-- 因为数据库自动给主键列创建了索引，查询语句出现了id会自动进行索引查询
select  * from test1 where id = 1;

-- 因为username 没有创建索引，为此需要一个一个的比较
select * from test1 where username= 'username1';

create index index_test_username on test1(username); -- 默认为升序

create index index_test_username_password_desc on test1(username,password desc); -- 默认为升序

show index from test1;

drop index index_test_username on test1;

ALTER table test1 drop index index_test_username_password_desc;




