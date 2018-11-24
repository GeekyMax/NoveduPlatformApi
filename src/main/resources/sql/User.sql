-- auto Generated on 2018-11-23
DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id        VARCHAR(50)         NOT NULL
  COMMENT 'id',
  username  VARCHAR(50) UNIQUE  NOT NULL
  COMMENT 'username',
  name      VARCHAR(50)         NOT NULL
  COMMENT 'name',
  password  VARCHAR(50)         NOT NULL
  COMMENT 'password',
  user_type VARCHAR(50)         NOT NULL DEFAULT 'STUDENT'
  COMMENT 'userType',
  INDEX (id),
  INDEX (name),
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT 'user';
