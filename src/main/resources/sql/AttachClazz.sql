-- auto Generated on 2018-11-24
-- DROP TABLE IF EXISTS attach_clazz;
CREATE TABLE attach_clazz (
  id         VARCHAR(50) NOT NULL
  COMMENT '唯一id',
  student_id VARCHAR(50) NOT NULL
  COMMENT '学生id',
  clazz_id   VARCHAR(50) NOT NULL
  COMMENT '班级id',
  INDEX (id),
  PRIMARY KEY (id),
  FOREIGN KEY (student_id) REFERENCES student_info (id),
  FOREIGN KEY (clazz_id) REFERENCES clazz (id),
  UNIQUE (student_id, clazz_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT 'attach_clazz';
