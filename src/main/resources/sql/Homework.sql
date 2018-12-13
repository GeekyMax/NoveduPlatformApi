-- auto Generated on 2018-12-13
DROP TABLE IF EXISTS homework;
CREATE TABLE homework
(
  id             VARCHAR(50) NOT NULL COMMENT '作业唯一id',
  clazz_id       VARCHAR(50) NOT NULL COMMENT '唯一id',
  title          VARCHAR(50) NOT NULL COMMENT '标题',
  content        TEXT        NOT NULL COMMENT '详细内容',
  notice         TEXT        NOT NULL COMMENT '注意事项',
  create_time    TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP  COMMENT '创建时间',
  active_time    TIMESTAMP            DEFAULT NULL COMMENT '启用时间',
  deadline       TIMESTAMP            DEFAULT NULL COMMENT '截止日期',
  homework_state VARCHAR(50) NOT NULL DEFAULT 'NOT_SET' COMMENT '作业状态',
  PRIMARY KEY (id),
  FOREIGN KEY (clazz_id) REFERENCES clazz (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT 'homework';
