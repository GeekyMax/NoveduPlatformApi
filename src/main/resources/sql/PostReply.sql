-- auto Generated on 2018-11-27
DROP TABLE IF EXISTS post_reply;
CREATE TABLE post_reply (
  id           VARCHAR(50) NOT NULL
  COMMENT '唯一id',
  post_id      VARCHAR(50) NOT NULL
  COMMENT '主贴id',
  reference_id VARCHAR(50)
  COMMENT '引用回复id',
  content      TEXT        NOT NULL
  COMMENT '回复内容',
  user_id      VARCHAR(50) NOT NULL,
  reply_time   TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '回帖时间',
  PRIMARY KEY (id),
  INDEX (id),
  FOREIGN KEY (post_id) REFERENCES post (id),
  FOREIGN KEY (reference_id) REFERENCES post_reply (id),
  FOREIGN KEY (user_id) REFERENCES user (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT 'post_reply';
