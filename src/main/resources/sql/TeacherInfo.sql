-- auto Generated on 2018-11-24
-- DROP TABLE IF EXISTS teacher_info;
CREATE TABLE teacher_info (
  id              VARCHAR(50)        NOT NULL
  COMMENT '教师唯一id',
  username        VARCHAR(50) UNIQUE NOT NULL
  COMMENT '教师卡号',
  name            VARCHAR(50)        NOT NULL
  COMMENT '教师姓名',
  sex             VARCHAR(10)        NOT NULL DEFAULT 'MALE'
  COMMENT '教师性别 默认男',
  college         VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '教师所属学院',
  department      VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '教师所属系',
  position        VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '教师职位',
  education       VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '教师学历',
  past_evaluation VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '教师以往教学评价',
  teach_style     VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '教学风格',
  publish         VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '出版作品',
  honor           VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '教师所获荣誉',
  more            VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '更多信息',
  phone           VARCHAR(20)        NOT NULL DEFAULT ''
  COMMENT '教师电话',
  email           VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '教师电子邮箱',
  INDEX (id),
  INDEX (username),
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES user (id)

)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT 'teacher_info';
