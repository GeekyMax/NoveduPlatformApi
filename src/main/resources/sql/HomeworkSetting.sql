-- auto Generated on 2018-12-13
DROP TABLE IF EXISTS homework_setting;
CREATE TABLE homework_setting
(
  homework_id              VARCHAR(50) NOT NULL COMMENT '作业id',
  coverable                TINYINT(3)  NOT NULL DEFAULT 1 COMMENT '是否可覆盖',
  overdueable              TINYINT(3)  NOT NULL DEFAULT 0 COMMENT '是否可逾期提交',
  personal                 TINYINT(3)  NOT NULL DEFAULT 0 COMMENT '是否属于个人作业(非个人即小组作业)',
  allow_team_member_submit TINYINT(3)  NOT NULL DEFAULT 0 COMMENT '允许组员提交',
  PRIMARY KEY (homework_id),
  FOREIGN KEY (homework_id) REFERENCES homework(id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT 'homework_setting';
