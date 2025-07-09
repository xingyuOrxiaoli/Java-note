use learndatabase;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`
(
    id BIGINT NOT NULL COMMENT '÷˜º¸ID',
    name VARCHAR(30) NULL DEFAULT NULL COMMENT '–’√˚',
    age INT NULL DEFAULT NULL COMMENT 'ƒÍ¡‰',
    email VARCHAR(50) NULL DEFAULT NULL COMMENT '” œ‰',
    PRIMARY KEY (id)
);

DELETE FROM `user`;

INSERT INTO `user` (id, name, age, email) VALUES
                                              (1, 'Jone', 18, 'test1@baomidou.com'),
                                              (2, 'Jack', 20, 'test2@baomidou.com'),
                                              (3, 'Tom', 28, 'test3@baomidou.com'),
                                              (4, 'Sandy', 21, 'test4@baomidou.com'),
                                              (5, 'Billie', 24, 'test5@baomidou.com');

select * from user

