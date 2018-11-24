-- auto Generated on 2018-11-24
DROP TABLE IF EXISTS student_info;
CREATE TABLE student_info (
  id       VARCHAR(50)        NOT NULL
  COMMENT '唯一id',
  username VARCHAR(50) UNIQUE NOT NULL
  COMMENT '学生学号',
  name     VARCHAR(50)        NOT NULL
  COMMENT '学生姓名',
  sex      VARCHAR(10)        NOT NULL DEFAULT 'MALE'
  COMMENT '学生性别',
  college  VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '学生学院',
  major    VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '学生专业',
  grade    VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '学生年级',
  clazz    VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '学生班级',
  phone    VARCHAR(20)        NOT NULL DEFAULT ''
  COMMENT '学生电话',
  email    VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '学生邮箱',
  INDEX (id),
  INDEX (username),
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES user (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT 'student_info';
