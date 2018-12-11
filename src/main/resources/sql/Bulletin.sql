-- auto Generated on 2018-12-11
-- DROP TABLE IF EXISTS bulletin;
CREATE TABLE bulletin
(
  id          VARCHAR(50) NOT NULL COMMENT '公告唯一id',
  clazz_id    VARCHAR(50) NOT NULL COMMENT '班级id',
  title       VARCHAR(50) NOT NULL COMMENT '公告标题',
  content     TEXT        NOT NULL COMMENT '公告内容',
  create_time TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '发布时间',
  PRIMARY KEY (id),
  FOREIGN KEY (clazz_id) REFERENCES clazz (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT 'bulletin';
