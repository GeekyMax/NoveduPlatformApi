-- auto Generated on 2018-12-10
-- DROP TABLE IF EXISTS clazz_resource;
CREATE TABLE clazz_resource
(
  id       VARCHAR(50) NOT NULL COMMENT '课程资源唯一id',
  clazz_id VARCHAR(50) NOT NULL COMMENT '所属班级id',
  file_id  VARCHAR(50) NOT NULL COMMENT '文件id',
  name     VARCHAR(50) NOT NULL COMMENT '展示的名字,不同于文件名',
  visible  TINYINT(3)  NOT NULL DEFAULT 0 COMMENT '是否可见',
  detail   VARCHAR(50) NOT NULL DEFAULT '' COMMENT '详细信息',
  PRIMARY KEY (id),
  FOREIGN KEY (file_id) REFERENCES file_info (id),
  FOREIGN KEY (clazz_id) REFERENCES clazz (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT 'clazz_resource';
