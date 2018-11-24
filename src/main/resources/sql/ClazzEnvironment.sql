-- auto Generated on 2018-11-24
DROP TABLE IF EXISTS clazz_environment;
CREATE TABLE clazz_environment (
  id       VARCHAR(50) NOT NULL
  COMMENT '唯一id',
  clazz_id VARCHAR(50) NOT NULL
  COMMENT '上课id',
  time     VARCHAR(50) NOT NULL DEFAULT ''
  COMMENT '上课时间',
  place    VARCHAR(50) NOT NULL DEFAULT ''
  COMMENT '上课地点',
  INDEX (id),
  PRIMARY KEY (id),
  FOREIGN KEY (clazz_id) REFERENCES clazz(id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT 'clazz_environment';
