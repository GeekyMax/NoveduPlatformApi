-- 用户user数据表
DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id        VARCHAR(50)         NOT NULL
  COMMENT 'id',
  username  VARCHAR(50) UNIQUE  NOT NULL
  COMMENT '用户学工号',
  name      VARCHAR(50)         NOT NULL
  COMMENT '用户名',
  password  VARCHAR(50)         NOT NULL
  COMMENT '密码',
  user_type VARCHAR(50)         NOT NULL DEFAULT 'STUDENT'
  COMMENT '用户类别',
  INDEX (id),
  INDEX (name),
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT 'user';
-- 学生信息表
DROP TABLE IF EXISTS student_info;
CREATE TABLE student_info (
  id       VARCHAR(50)        NOT NULL
  COMMENT '唯一id',
  username VARCHAR(50) UNIQUE NOT NULL
  COMMENT '学生学号',
  name     VARCHAR(50)        NOT NULL
  COMMENT '学生姓名',
  sex      VARCHAR(10)        NOT NULL DEFAULT 'MALE'
  COMMENT '学生性别',
  college  VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '学生学院',
  major    VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '学生专业',
  grade    VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '学生年级',
  clazz    VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '学生班级',
  phone    VARCHAR(20)        NOT NULL DEFAULT ''
  COMMENT '学生电话',
  email    VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '学生邮箱',
  INDEX (id),
  INDEX (username),
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES user (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT 'student_info';
-- 教师信息表
DROP TABLE IF EXISTS teacher_info;
CREATE TABLE teacher_info (
  id              VARCHAR(50)        NOT NULL
  COMMENT '教师唯一id',
  username        VARCHAR(50) UNIQUE NOT NULL
  COMMENT '教师卡号',
  name            VARCHAR(50)        NOT NULL
  COMMENT '教师姓名',
  sex             VARCHAR(10)        NOT NULL DEFAULT 'MALE'
  COMMENT '教师性别 默认男',
  college         VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '教师所属学院',
  department      VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '教师所属系',
  position        VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '教师职位',
  education       VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '教师学历',
  past_evaluation VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '教师以往教学评价',
  teach_style     VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '教学风格',
  publish         VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '出版作品',
  honor           VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '教师所获荣誉',
  more            VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '更多信息',
  phone           VARCHAR(20)        NOT NULL DEFAULT ''
  COMMENT '教师电话',
  email           VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '教师电子邮箱',
  INDEX (id),
  INDEX (username),
  PRIMARY KEY (id),
  FOREIGN KEY (id) REFERENCES user (id)

)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT 'teacher_info';
-- 课程表
DROP TABLE IF EXISTS course;
CREATE TABLE course (
  id                 VARCHAR(50)        NOT NULL
  COMMENT '课程唯一id',
  name               VARCHAR(50)        NOT NULL
  COMMENT '课程名称',
  code               VARCHAR(50) UNIQUE NOT NULL
  COMMENT '课程代码',
  textbook           VARCHAR(50)        NOT NULL DEFAULT '无'
  COMMENT '课程教材',
  type               VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '课程种类',
  year               VARCHAR(50)        NOT NULL DEFAULT '长期'
  COMMENT '课程学年',
  semester           VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '课程学期',
  english_name       VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '课程英文名',
  college            VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '开课学院',
  credit             DOUBLE(16, 4)      NOT NULL DEFAULT '0'
  COMMENT '课程学分',
  week_learning_time INT(11)            NOT NULL DEFAULT '0'
  COMMENT '周学时',
  weight             VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '权重',
  pre_learning       VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '预修课程',
  plan               VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '教学计划',
  background         VARCHAR(50)        NOT NULL DEFAULT ''
  COMMENT '课程背景',
  INDEX (id),
  INDEX (code),
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT 'course';
--  班级信息表
DROP TABLE IF EXISTS clazz;
CREATE TABLE clazz (
  id            VARCHAR(50)        NOT NULL
  COMMENT '开课id',
  code          VARCHAR(50) UNIQUE NOT NULL
  COMMENT '本课代码',
  student_count INT(11)            NOT NULL DEFAULT '0'
  COMMENT '学生数量',
  course_id     VARCHAR(50)        NOT NULL
  COMMENT '课程id',
  INDEX (id),
  INDEX (code),
  PRIMARY KEY (id),
  FOREIGN KEY (course_id) REFERENCES course (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT 'clazz';
-- 班级上课时间地点表
DROP TABLE IF EXISTS clazz_environment;
CREATE TABLE clazz_environment (
  id       VARCHAR(50) NOT NULL
  COMMENT '唯一id',
  clazz_id VARCHAR(50) NOT NULL
  COMMENT '上课id',
  time     VARCHAR(50) NOT NULL DEFAULT ''
  COMMENT '上课时间',
  place    VARCHAR(50) NOT NULL DEFAULT ''
  COMMENT '上课地点',
  INDEX (id),
  PRIMARY KEY (id),
  FOREIGN KEY (clazz_id) REFERENCES clazz (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT 'clazz_environment';
-- 班级设置表
DROP TABLE IF EXISTS clazz_setting;
CREATE TABLE clazz_setting (
  clazz_id              VARCHAR(50) NOT NULL
  COMMENT '开课id',
  team_allowed          TINYINT(3)  NOT NULL DEFAULT 0
  COMMENT '是否允许组建小组',
  max_team_member_count INT(11)     NOT NULL DEFAULT -1
  COMMENT '每小组人数上限',
  max_team_count        INT(11)     NOT NULL DEFAULT -1
  COMMENT '小组数量上限',
  INDEX (clazz_id),
  PRIMARY KEY (clazz_id),
  FOREIGN KEY (clazz_id) REFERENCES clazz (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT 'clazz_setting';
-- 学生上课表
DROP TABLE IF EXISTS attend_clazz;
CREATE TABLE attend_clazz (
  id         VARCHAR(50) NOT NULL
  COMMENT '唯一id',
  student_id VARCHAR(50) NOT NULL
  COMMENT '学生id',
  clazz_id   VARCHAR(50) NOT NULL
  COMMENT '班级id',
  team_id    VARCHAR(50) NOT NULL DEFAULT ''
  COMMENT '加入队伍id',
  INDEX (id),
  PRIMARY KEY (id),
  FOREIGN KEY (student_id) REFERENCES student_info (id),
  FOREIGN KEY (clazz_id) REFERENCES clazz (id),
  UNIQUE (student_id, clazz_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT 'attend_clazz';
-- 教师授课表
DROP TABLE IF EXISTS teach_clazz;
CREATE TABLE teach_clazz (
  id         VARCHAR(50) NOT NULL
  COMMENT '唯一id',
  teacher_id VARCHAR(50) NOT NULL
  COMMENT '教师id',
  clazz_id   VARCHAR(50) NOT NULL
  COMMENT '上课id',
  INDEX (id),
  PRIMARY KEY (id),
  FOREIGN KEY (teacher_id) REFERENCES teacher_info (id),
  FOREIGN KEY (clazz_id) REFERENCES clazz (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COMMENT 'teach_clazz';
-- 队伍信息表
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
-- 加入队伍请求表
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
