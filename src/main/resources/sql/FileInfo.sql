-- auto Generated on 2018-12-10
-- DROP TABLE IF EXISTS file_info;
CREATE TABLE file_info
(
  id      VARCHAR(50) NOT NULL COMMENT '唯一编号',
  name    VARCHAR(50) NOT NULL COMMENT '文件名(不唯一',
  type    VARCHAR(50) NOT NULL DEFAULT 'OTHER' COMMENT '文件类型',
  fix     VARCHAR(50) NOT NULL DEFAULT '' COMMENT '文件后缀名',
  size    BIGINT(15)  NOT NULL COMMENT '文件大小',
  path    VARCHAR(50) NOT NULL COMMENT '文件所在路径',
  user_id VARCHAR(50) NOT NULL COMMENT '上传用户id',
  remark  VARCHAR(50) NOT NULL DEFAULT '' COMMENT '备注',
  other   VARCHAR(50) NOT NULL DEFAULT '' COMMENT '其他信息',
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES user (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT 'file_info';
