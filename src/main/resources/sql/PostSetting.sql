-- auto Generated on 2018-11-27
-- DROP TABLE IF EXISTS post_setting;
CREATE TABLE post_setting (
  post_id         VARCHAR(50) NOT NULL
  COMMENT '主题帖id',
  post_permission VARCHAR(50) NOT NULL DEFAULT 'ALL'
  COMMENT '本贴权限',
  team_id         VARCHAR(50) NOT NULL
  COMMENT '所属队伍id',
  INDEX (post_id),
  PRIMARY KEY (post_id),
  FOREIGN KEY (post_id) REFERENCES post (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT 'post_setting';
