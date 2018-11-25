-- auto Generated on 2018-11-24
DROP TABLE IF EXISTS attend_clazz;
CREATE TABLE attend_clazz (
  id         VARCHAR(50) NOT NULL
  COMMENT '唯一id',
  student_id VARCHAR(50) NOT NULL
  COMMENT '学生id',
  clazz_id   VARCHAR(50) NOT NULL
  COMMENT '班级id',
  team_id    VARCHAR(50) NOT NULL DEFAULT ''
  COMMENT '加入队伍id',
  INDEX (id),
  PRIMARY KEY (id),
  FOREIGN KEY (student_id) REFERENCES student_info (id),
  FOREIGN KEY (clazz_id) REFERENCES clazz (id),
  UNIQUE (student_id, clazz_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT 'attend_clazz';
