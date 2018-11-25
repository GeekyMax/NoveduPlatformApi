-- auto Generated on 2018-11-25
DROP TABLE IF EXISTS team;
CREATE TABLE team (
  id            VARCHAR(50) NOT NULL
  COMMENT '队伍 id',
  name          VARCHAR(50) NOT NULL
  COMMENT '队伍名称',
  description   VARCHAR(50) NOT NULL DEFAULT '无'
  COMMENT '队伍描述',
  clazz_id      VARCHAR(50) NOT NULL
  COMMENT '所属班级id',
  leader_id     VARCHAR(50) NOT NULL
  COMMENT '队长id',
  member_number INT(11)     NOT NULL DEFAULT 1
  COMMENT '成员数',
  create_time   TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
  ON UPDATE CURRENT_TIMESTAMP
  COMMENT '创建时间',
  INDEX (id),
  PRIMARY KEY (id),
  FOREIGN KEY (leader_id) REFERENCES student_info (id),
  FOREIGN KEY (clazz_id) REFERENCES clazz (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT 'team';
