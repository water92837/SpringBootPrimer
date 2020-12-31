
-- 建表
CREATE TABLE `user` (
                        `id` int(10) unsigned NOT NULL,
                        `name` varchar(50) NOT NULL,
                        `mobile` varchar(20) DEFAULT NULL,
                        `email` varchar(50) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 插入数据
INSERT INTO USER (ID, NAME, MOBILE, EMAIL) VALUES (1, '张建东', '13778362787', 'zhangjd@126.com');
INSERT INTO USER (ID, NAME, MOBILE, EMAIL) VALUES (2, '李东升', '15178982367', 'lids@126.com');
INSERT INTO USER (ID, NAME, MOBILE, EMAIL) VALUES (3, '李书福', '13155768777', 'lisf@126.com');
INSERT INTO USER (ID, NAME, MOBILE, EMAIL) VALUES (4, '王炸', '18899001234', 'wangzha@163.com');
INSERT INTO USER (ID, NAME, MOBILE, EMAIL) VALUES (5, '狄仁杰', '18880001000', 'direnjie@163.com');
INSERT INTO USER (ID, NAME, MOBILE, EMAIL) VALUES (6, '瓦坎达', '18866668888', 'Kings@163.com');
INSERT INTO USER (ID, NAME, MOBILE, EMAIL) VALUES (7, '茅台', '01234567891', 'email@update.com');
INSERT INTO USER (ID, NAME, MOBILE, EMAIL) VALUES (8, '刘烨', '18880001000', 'liuye@163.com');
INSERT INTO USER (ID, NAME, MOBILE, EMAIL) VALUES (9, '于善福', '18880001000', 'yusf@163.com');
INSERT INTO USER (ID, NAME, MOBILE, EMAIL) VALUES (10, '我是我', '101010101010', '101010@test.com');