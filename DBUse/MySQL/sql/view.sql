
create or replace view findTest1
as
    select * from test1
    where id != 4
    with check option  -- 检查是否符合id!= 4的条件对于下面的添加元素 如果等于4则不能添加
;

select * from findTest1;

insert into findTest1 values (7,'username7','password7');

insert into findTest1 values (4,'username4','password4');

-- TODO
create or replace view findTest1AndTest3
as
    select * from test1 left join test3 on (test1.id = test3.test1Id)
;

