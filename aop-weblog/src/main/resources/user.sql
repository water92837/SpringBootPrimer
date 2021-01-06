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
INSERT INTO USER (ID, NAME, MOBILE, EMAIL) VALUES (6, '李元芳', '18866666666', 'lyf@163.com');