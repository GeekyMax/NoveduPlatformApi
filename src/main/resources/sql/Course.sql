-- auto Generated on 2018-11-24
DROP TABLE IF EXISTS course;
CREATE TABLE course (
  id                 VARCHAR(50)        NOT NULL
  COMMENT '课程唯一id',
  name               VARCHAR(50)        NOT NULL
  COMMENT '课程名称',
  textbook           VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '课程教材',
  code               VARCHAR(50) UNIQUE NOT NULL
  COMMENT '课程代码',
  type               VARCHAR(50)        NOT NULL
  COMMENT '课程种类',
  year               VARCHAR(50)        NOT NULL
  COMMENT '课程学年',
  semester           VARCHAR(50)        NOT NULL
  COMMENT '课程学期',
  english_name       VARCHAR(50)        NOT NULL
  COMMENT '课程英文名',
  college            VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '开课学院',
  credit             DOUBLE(16, 4)      NOT NULL
  COMMENT '课程学分',
  week_learning_time INT(11)            NOT NULL
  COMMENT '周学时',
  weight             VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '权重',
  pre_learning       VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '预修课程',
  plan               VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '教学计划',
  background         VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '课程背景',
  INDEX (id),
  INDEX (code),
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT 'course';
