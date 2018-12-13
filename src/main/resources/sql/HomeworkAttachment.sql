-- auto Generated on 2018-12-13
DROP TABLE IF EXISTS homework_attachment;
CREATE TABLE homework_attachment
(
  id           VARCHAR(50) NOT NULL COMMENT '附件唯一id',
  user_id      VARCHAR(50) NOT NULL COMMENT '用户id',
  homework_id  VARCHAR(50) COMMENT '所属homeworkId',
  file_info_id VARCHAR(50) NOT NULL COMMENT '所带文件',
  PRIMARY KEY (id),
  FOREIGN KEY (homework_id) REFERENCES homework (id),
  FOREIGN KEY (user_id) REFERENCES user (id),
  FOREIGN KEY (file_info_id) REFERENCES file_info (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT 'homework_attachment';
