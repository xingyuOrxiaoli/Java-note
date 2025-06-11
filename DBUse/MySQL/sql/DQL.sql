
select * from test1;

-- distinct  去重 对后面所有列去重
select distinct id from test1;

-- 不等于 <> 和 !=两种写法
-- 排序
select distinct * from test1 order by test1.id DESC; -- 降序
select distinct * from test1 order by test1.id asc ,username desc ; -- 默认 升序
select distinct * from test1 ; -- 默认 按照主键排序  oracle不一定按照主键排序

select distinct * from test1 where username = 'Username1'; -- 默认不区分大小写

select distinct * from test1 where binary username = 'Username1';  -- binary区分大小写

select distinct * from test1 where username is null;

select distinct * from test1 where username is not null;

select distinct * from test1 where username like '__e%';


-- 使用函数
select distinct lower(test1.username) , upper(test1.password) from test1;

select distinct max(test1.id) , min(test1.id) , count(test1.id) ,avg(id) , sum(id) from test1;

-- 字符串函数
select distinct
    username,
    length(test1.username) ,
    substring(username,2,4) -- 从第2开始 长度为 4
from test1;

-- 数值函数

select
    abs(-10),
    ceil(5.5),
    floor(5.5),
    round(5.5),
    round(5.4),  -- 四舍五入
    10 /3,
    mod(-10,3),
    -10 % 3,
    pow(2,3),
    rand(10)
;

-- 日期和时间

select * from test2;


select
    curdate(),
    curtime(),
    now(),
    sysdate() ,
    sleep(3),
    now(),  -- sleep没有影响
    sysdate()
from
    test2
;

-- 流程函数

select
    id,
    if(username <= 'username1','第一个账号','不是第一个账号'),
    ifnull(username,'没有设置用户名的账号'),
    nullif(1,2),
    nullif(1,1)-- 如果连个数相等，则返回Null 反之返回第一个数

from test1;


-- case的等值判断
select
    id,
    case username
        when 'username1' then '第一个账号'
        when 'username2' then '第二个账号'
        when 'username3' then '第三个账号'
        else '其他账号'
    end  as`case的等值判断`
from test1;

-- case的不等值判断
select
    id,
    case
        when username = 'username1' then '第一个账号'
        when username = 'username2' then '第二个账号'
        when username = 'username3' then '第三个账号'
        else '其他账号'
        end  as`case的不等值判断`
from test1;

-- JSON函数


-- 其他函数
select
    database(),
    user(),
    version()
;

select
    password('root') -- MySQL8不在支持
;

-- 多行函数 会自动忽略 null 解决 ifnull(字段,value)


select
    *
from
    test1
where username != 'username1'  -- 不能存在多行函数
group by id
having lower(username) != 'username2'  -- 能存在多行函数
order by id
;





