
-- 没有返回值
create procedure  demo1 (id int(255),username varchar(255))
begin
    if username is null or username = '' then
        select * from test1 where test1.username like concat('%',id,'%'); -- 不能使用加号
    else
        select * from test1 where test1.username = username;
    end if;
end;


drop procedure demo1;

call demo1(1,null);

call demo1(1 , 'username2');

call demo1(1 ,'');


-- 有返回值的存储过程
create procedure demo2(id int(255),username varchar(255) , out num int(255))
begin
    if username is null or username = '' then
        select * from test1 where test1.username like concat('%',id,'%'); -- 不能使用加号
    else
        select * from test1 where test1.username = username;
    end if;
    select found_rows() into num;
end;

drop procedure demo2;

call demo2(1 , 'username2' , @num);

select @num;
