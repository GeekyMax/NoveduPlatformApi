-- auto Generated on 2018-11-24
DROP TABLE IF EXISTS clazz;
CREATE TABLE clazz (
  id            VARCHAR(50)        NOT NULL
  COMMENT '开课id',
  code          VARCHAR(50) UNIQUE NOT NULL
  COMMENT '本课代码',
  student_count INT(11)            NOT NULL DEFAULT '0'
  COMMENT '学生数量',
  course_id     VARCHAR(50)        NOT NULL
  COMMENT '课程id',
  INDEX (id),
  INDEX (code),
  PRIMARY KEY (id),
  FOREIGN KEY (course_id) REFERENCES course (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT 'clazz';
