-- auto Generated on 2018-11-24
-- DROP TABLE IF EXISTS clazz_setting;
CREATE TABLE clazz_setting (
  clazz_id              VARCHAR(50) NOT NULL
  COMMENT '开课id',
  team_allowed          TINYINT(3)  NOT NULL DEFAULT 0
  COMMENT '是否允许组建小组',
  max_team_number_count INT(11)     NOT NULL DEFAULT -1
  COMMENT '每小组人数上限',
  INDEX (clazz_id),
  PRIMARY KEY (clazz_id),
  FOREIGN KEY (clazz_id) REFERENCES clazz (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT 'clazz_setting';
