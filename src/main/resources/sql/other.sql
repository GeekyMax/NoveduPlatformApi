-- other important table
DROP TABLE IF EXISTS teach_clazz;
CREATE TABLE teach_clazz (
  id         VARCHAR(50) NOT NULL PRIMARY KEY,
  teacher_id VARCHAR(50) NOT NULL
  COMMENT '教师id',
  clazz_id   VARCHAR(50) NOT NULL
  COMMENT '上课id',
  PRIMARY KEY (id),
  UNIQUE (teacher_id, clazz_id),
  FOREIGN KEY (teacher_id) REFERENCES teacher_info (id),
  FOREIGN KEY (clazz_id) REFERENCES clazz (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT 'clazz';