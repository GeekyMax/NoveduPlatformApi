-- auto Generated on 2018-11-24
-- DROP TABLE IF EXISTS teach_clazz;
CREATE TABLE teach_clazz (
  id         VARCHAR(50) NOT NULL
  COMMENT '唯一id',
  teacher_id VARCHAR(50) NOT NULL
  COMMENT '教师id',
  clazz_id   VARCHAR(50) NOT NULL
  COMMENT '上课id',
  INDEX (id),
  PRIMARY KEY (id),
  FOREIGN KEY (teacher_id) REFERENCES teacher_info (id),
  FOREIGN KEY (clazz_id) REFERENCES clazz (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT 'teach_clazz';
