-- auto Generated on 2018-11-27
DROP TABLE IF EXISTS reply_comment;
CREATE TABLE reply_comment (
  id           VARCHAR(50) NOT NULL
  COMMENT '唯一id',
  reply_id     VARCHAR(50) NOT NULL
  COMMENT '回帖id',
  content      TEXT        NOT NULL
  COMMENT '回复内容',
  user_id      VARCHAR(50) NOT NULL
  COMMENT '学生id',
  comment_time TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '回复时间',
  INDEX (id),
  PRIMARY KEY (id),
  FOREIGN KEY (reply_id) REFERENCES post_reply (id),
  FOREIGN KEY (user_id) REFERENCES user (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT 'reply_comment';
