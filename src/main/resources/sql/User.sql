-- auto Generated on 2018-11-23
DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id        VARCHAR(50)         NOT NULL
  COMMENT 'id',
  username  VARCHAR(50) UNIQUE  NOT NULL
  COMMENT '用户学工号',
  name      VARCHAR(50)         NOT NULL
  COMMENT '用户名',
  password  VARCHAR(50)         NOT NULL
  COMMENT '密码',
  user_type VARCHAR(50)         NOT NULL DEFAULT 'STUDENT'
  COMMENT '用户类别',
  INDEX (id),
  INDEX (name),
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT 'user';
