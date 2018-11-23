-- auto Generated on 2018-11-22
DROP TABLE IF EXISTS user;
CREATE TABLE user(
	id VARCHAR (50) NOT NULL COMMENT 'id',
	name VARCHAR (50) UNIQUE NOT NULL COMMENT 'name',
	password VARCHAR (50) NOT NULL COMMENT 'password',
	INDEX(id),
	INDEX(name),
	INDEX `ix_name`(name),
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'user';
