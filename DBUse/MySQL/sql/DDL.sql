create database note;


create table test1(
    id int(255) primary key ,
    username varchar(255),
    password varchar(255)
);
-- 快速创建表  数据也会跟着拷贝一份
create table test2
AS
    select * from test1
;
-- 增加

alter table test1 add score double(5,2); -- 5是总数  2 是小数
alter table test1 add score double(5,2) first ;
alter table test2 add createtime datetime;

-- 修改

alter table test1 modify score float(3,1);
alter table test1 change score score1 double(4,1);

-- 删除

alter table test1 drop score ;


drop table test2 ;

