--创建account表
CREATE TABLE IF NOT EXISTS `product`(
   `id` INT,
   `name` VARCHAR(20),
   `price` DECIMAL(10,2),
   `desc` VARCHAR(20),
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO product VALUES (1,'test1',10.1,'ceshi1');
INSERT INTO product VALUES (2,'test2',22.11,'ceshi2');
