-- auto Generated on 2018-11-27
-- DROP TABLE IF EXISTS post;
CREATE TABLE post (
  id          VARCHAR(50)  NOT NULL
  COMMENT '唯一编号id',
  title       VARCHAR(100) NOT NULL
  COMMENT '文章标题',
  content     TEXT         NOT NULL
  COMMENT '文章内容',
  post_time   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '发布时间',
  reply_time  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP
  COMMENT '最后回复时间',
  reply_count INT(11)      NOT NULL DEFAULT 0
  COMMENT '回复数量',
  clazz_id    VARCHAR(50)  NOT NULL
  COMMENT '所属班级信息',
  user_id     VARCHAR(50)  NOT NULL
  COMMENT '用户信息',
  INDEX (id),
  PRIMARY KEY (id),
  FOREIGN KEY (clazz_id) REFERENCES clazz (id),
  FOREIGN KEY (user_id) REFERENCES user (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT 'post';
