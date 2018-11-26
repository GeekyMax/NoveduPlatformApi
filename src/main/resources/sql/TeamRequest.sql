-- auto Generated on 2018-11-26
DROP TABLE IF EXISTS team_request;
CREATE TABLE team_request (
  id                 VARCHAR(50) NOT NULL
  COMMENT '请求唯一id',
  student_id         VARCHAR(50) NOT NULL
  COMMENT '学生id',
  team_id            VARCHAR(50) NOT NULL
  COMMENT '队伍id',
  team_request_state VARCHAR(50) NOT NULL DEFAULT 'PENDING'
  COMMENT '请求状态',
  create_time        TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '请求发起时间',
  handle_time        TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP
  COMMENT '请求处理时间',
  INDEX (id),
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT 'team_request';
