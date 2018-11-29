# NoveduApi设计

[TOC]



## Ⅰ 网站根目录

novedu.cn/api/v1/

## Ⅱ 响应格式

对于所有的请求，响应格式都是一个 JSON 对象。

一个请求是否成功是由 HTTP 状态码标明的。一个 2XX 的状态码表示成功，而一个 4XX 表示请求失败。当一个请求失败时响应的主体仍然是一个 JSON 对象，但是总是会包含 `code` 和 `msg` 这两个字段，你可以用它们来进行调试。

```json
{
    "meta":{
        "code":404
        "success": false,
        "msg": "service exception"
    },
    "data":{}
}
```

成功状态下：

```json
{
    "meta":{
        "code":200
        "success": true,
        "msg": "ok"
    },
    "data":{}
}
```

## Ⅲ 关于登录

登录 /login POST, data:

```json
{
    "username":"max","password":"32@ds*@&dsa"
}
```

返回结果

```json
{
    "token":"qmdj8pdidnmyzp0c7yqil91oc",
    ...
}
```

之后发送请求时在header中加入 X-NOV-TOKEN: eyJhbGciOiJIUzI1NiJ9.xxx用于用户验证。

## Ⅳ api目录

省略版本号

- 用户相关
  - /api/auth/login POST 用户登录
  - /api/auth/register POST 用户注册
  - /api/auth/change-password POST 修改用户密码
  - /api/users 用户信息
- 课程信息(包括课程基本信息，教学大纲，教师信息)
  - /api/classes GET 获取所有课程信息
  - /api/classes/:id GET 获取指定课程信息
- 课程组队
  - /api/classes/:id/teams GET 获取所有队伍信息（支持过滤信息）
  - /api/classes/:id/teams/:id GET 获取指定队伍信息
  - /api/classes/:id/teams POST 新建一个队伍
  - /api/classes/:id/teams/:id DELETE 删除队伍
  - /api/classes/:id/teams/:id PUT 更新队伍信息
  - /api/classes/:id/teams/:id/request POST 加入某只队伍
  - /api/classes/:id/teams/:id/request GET 获取加入队伍信息
  - /api/classes/:id/teams/:id/request/handler POST 处理请求信息
- 课程论坛
  - /api/bbs/:id/posts GET 获取所有帖子信息(支持过滤信息)
  - /api/bbs/:id/posts/:id GET 获取指定帖子信息
  - /api/bbs/:id/posts POST 发布帖子
  - /api/bbs/:id/posts/:id PUT 修改帖子(内容,权限)
  - /api/bbs/:id/posts/:id DELETE 删除帖子
  - /api/bbs/:id/posts/:id/replies GET 获取所有帖子回复(支持过滤信息)
  - /api/bbs/:id/posts/:id/replies POST 发布回帖
  - /api/bbs/:id/posts/:id/replies/:reply_id DELETE 删除回帖
  - /api/replies/:reply-id/comments GET 回复回帖
  - /api/bbs/:id POST 修改论坛设置
  - /api/bbs/:id/query?q=xxx GET 搜索主题帖(支持过滤信息)
- 课程资料
  - /api/classes/:id/resources GET 获取课程资源列表(支持过滤信息)
  - /api/classes/:id/resources/:id GET 获取课程资源详细信息
  - /api/classes/:id/resources POST 添加课程资源
  - /api/classes/:id/resources/:id DELETE 删除资源
- 消息系统
  - /api/messages GET 消息列表 获取消息列表(支持过滤信息)
  - /api/messages/:id GET 获得指定消息信息
  - /api/messages/:id POST 响应消息 
  - /api/messages/:id DELETE 删除消息
  - 

## Ⅴ过滤信息

```
?limit=10：指定返回记录的数量
?offset=10：指定返回记录的开始位置。
?page=2&per_page=100：指定第几页，以及每页的记录数。
?orderby=name&order=asc：指定返回结果按照哪个属性排序，以及排序顺序。
```



## Ⅵ api请求详细

### 用户相关

#### /api/auth/login POST 用户登录

### 课程信息

#### /api/classes GET 获取所有课程信息

#### /api/classes/:id GET 获取指定课程信息

### 课程组队

#### /api/classes/:id/teams GET 获取所有队伍信息（支持过滤信息）

#### /api/classes/:id/teams/:id GET 获取指定队伍信息

#### /api/classes/:id/teams POST 新建一个队伍

#### /api/classes/:id/teams/:id DELETE 删除队伍

#### /api/classes/:id/teams/:id PUT 更新队伍信息

#### /api/classes/:id/teams/:id/request POST 加入某只队伍

#### /api/classes/:id/teams/:id/request GET 获取加入队伍信息

#### /api/classes/:id/teams/:id/request/handler POST 处理请求信息

### 课程论坛

#### /api/bbs/:id/posts GET 获取所有帖子信息(支持过滤信息)

```json
{
    "meta": {
        "code": 200,
        "success": true,
        "message": "ok"
    },
    "data": {
        "clazz": {
            "id": "02fd3297f18e11e8973400163e043b02",
            "code": "T(2018-2019)-COURSE1-1",
            "course": {
                "id": "88ea12bbf18d11e8973400163e043b02",
                "name": "软件工程专业课1",
                "textbook": "无",
                "code": "T(2018-2019)-COURSE1",
                "type": "",
                "year": "长期",
                "semester": "",
                "englishName": "",
                "college": "",
                "credit": 0.0,
                "weekLearningTime": 0,
                "weight": "",
                "preLearning": "",
                "plan": "",
                "background": ""
            },
            "teachers": [
                {
                    "id": "6759be4af18d11e8973400163e043b02",
                    "username": "4160102210",
                    "name": "teacher10",
                    "sex": "MALE",
                    "college": "",
                    "department": "",
                    "position": "",
                    "education": "",
                    "pastEvaluation": "",
                    "teachStyle": "",
                    "publish": "",
                    "honor": "",
                    "more": "",
                    "phone": "",
                    "email": ""
                },
                {
                    "id": "67a88625f18d11e8973400163e043b02",
                    "username": "4160102211",
                    "name": "teacher11",
                    "sex": "MALE",
                    "college": "",
                    "department": "",
                    "position": "",
                    "education": "",
                    "pastEvaluation": "",
                    "teachStyle": "",
                    "publish": "",
                    "honor": "",
                    "more": "",
                    "phone": "",
                    "email": ""
                }
            ],
            "clazzEnvironments": [
                {
                    "id": "03295065f18e11e8973400163e043b02",
                    "clazzId": "02fd3297f18e11e8973400163e043b02",
                    "time": "周四0",
                    "place": "教四-100"
                },
                {
                    "id": "03387c1ff18e11e8973400163e043b02",
                    "clazzId": "02fd3297f18e11e8973400163e043b02",
                    "time": "周四1",
                    "place": "教四-101"
                }
            ],
            "studentCount": 0,
            "clazzSetting": {
                "clazzId": "02fd3297f18e11e8973400163e043b02",
                "teamAllowed": true,
                "maxTeamMemberCount": 3,
                "maxTeamCount": 3
            }
        },
        "allPost": [
            {
                "id": "3a4e3da0f24911e8973400163e043b02",
                "title": "title",
                "content": "content here",
                "userInfo": {
                    "id": "56969bc9f18d11e8973400163e043b02",
                    "username": "3160102210",
                    "name": "student10"
                },
                "postTime": 1543354496000,
                "replyTime": 1543354496000,
                "replyCount": 0,
                "clazz": {
                    "id": "02fd3297f18e11e8973400163e043b02",
                    "code": "T(2018-2019)-COURSE1-1",
                    "course": {
                        "id": "88ea12bbf18d11e8973400163e043b02",
                        "name": "软件工程专业课1",
                        "textbook": "无",
                        "code": "T(2018-2019)-COURSE1",
                        "type": "",
                        "year": "长期",
                        "semester": "",
                        "englishName": "",
                        "college": "",
                        "credit": 0.0,
                        "weekLearningTime": 0,
                        "weight": "",
                        "preLearning": "",
                        "plan": "",
                        "background": ""
                    },
                    "teachers": [
                        {
                            "id": "6759be4af18d11e8973400163e043b02",
                            "username": "4160102210",
                            "name": "teacher10",
                            "sex": "MALE",
                            "college": "",
                            "department": "",
                            "position": "",
                            "education": "",
                            "pastEvaluation": "",
                            "teachStyle": "",
                            "publish": "",
                            "honor": "",
                            "more": "",
                            "phone": "",
                            "email": ""
                        },
                        {
                            "id": "67a88625f18d11e8973400163e043b02",
                            "username": "4160102211",
                            "name": "teacher11",
                            "sex": "MALE",
                            "college": "",
                            "department": "",
                            "position": "",
                            "education": "",
                            "pastEvaluation": "",
                            "teachStyle": "",
                            "publish": "",
                            "honor": "",
                            "more": "",
                            "phone": "",
                            "email": ""
                        }
                    ],
                    "clazzEnvironments": [
                        {
                            "id": "03295065f18e11e8973400163e043b02",
                            "clazzId": "02fd3297f18e11e8973400163e043b02",
                            "time": "周四0",
                            "place": "教四-100"
                        },
                        {
                            "id": "03387c1ff18e11e8973400163e043b02",
                            "clazzId": "02fd3297f18e11e8973400163e043b02",
                            "time": "周四1",
                            "place": "教四-101"
                        }
                    ],
                    "studentCount": 0,
                    "clazzSetting": {
                        "clazzId": "02fd3297f18e11e8973400163e043b02",
                        "teamAllowed": true,
                        "maxTeamMemberCount": 3,
                        "maxTeamCount": 3
                    }
                },
                "postSetting": {
                    "postId": "3a4e3da0f24911e8973400163e043b02",
                    "postPermission": "ALL",
                    "teamId": ""
                }
            },
            {
                "id": "52e960d0f24911e8973400163e043b02",
                "title": "这是第三个帖子",
                "content": "third post",
                "userInfo": {
                    "id": "56969bc9f18d11e8973400163e043b02",
                    "username": "3160102210",
                    "name": "student10"
                },
                "postTime": 1543354537000,
                "replyTime": 1543354537000,
                "replyCount": 0,
                "clazz": {
                    "id": "02fd3297f18e11e8973400163e043b02",
                    "code": "T(2018-2019)-COURSE1-1",
                    "course": {
                        "id": "88ea12bbf18d11e8973400163e043b02",
                        "name": "软件工程专业课1",
                        "textbook": "无",
                        "code": "T(2018-2019)-COURSE1",
                        "type": "",
                        "year": "长期",
                        "semester": "",
                        "englishName": "",
                        "college": "",
                        "credit": 0.0,
                        "weekLearningTime": 0,
                        "weight": "",
                        "preLearning": "",
                        "plan": "",
                        "background": ""
                    },
                    "teachers": [
                        {
                            "id": "6759be4af18d11e8973400163e043b02",
                            "username": "4160102210",
                            "name": "teacher10",
                            "sex": "MALE",
                            "college": "",
                            "department": "",
                            "position": "",
                            "education": "",
                            "pastEvaluation": "",
                            "teachStyle": "",
                            "publish": "",
                            "honor": "",
                            "more": "",
                            "phone": "",
                            "email": ""
                        },
                        {
                            "id": "67a88625f18d11e8973400163e043b02",
                            "username": "4160102211",
                            "name": "teacher11",
                            "sex": "MALE",
                            "college": "",
                            "department": "",
                            "position": "",
                            "education": "",
                            "pastEvaluation": "",
                            "teachStyle": "",
                            "publish": "",
                            "honor": "",
                            "more": "",
                            "phone": "",
                            "email": ""
                        }
                    ],
                    "clazzEnvironments": [
                        {
                            "id": "03295065f18e11e8973400163e043b02",
                            "clazzId": "02fd3297f18e11e8973400163e043b02",
                            "time": "周四0",
                            "place": "教四-100"
                        },
                        {
                            "id": "03387c1ff18e11e8973400163e043b02",
                            "clazzId": "02fd3297f18e11e8973400163e043b02",
                            "time": "周四1",
                            "place": "教四-101"
                        }
                    ],
                    "studentCount": 0,
                    "clazzSetting": {
                        "clazzId": "02fd3297f18e11e8973400163e043b02",
                        "teamAllowed": true,
                        "maxTeamMemberCount": 3,
                        "maxTeamCount": 3
                    }
                },
                "postSetting": {
                    "postId": "52e960d0f24911e8973400163e043b02",
                    "postPermission": "ALL",
                    "teamId": ""
                }
            }
        ],
        "teamPost": [
            {
                "id": "13662ae3f1ea11e8973400163e043b02",
                "title": "title",
                "content": "content here",
                "userInfo": {
                    "id": "56969bc9f18d11e8973400163e043b02",
                    "username": "3160102210",
                    "name": "student10"
                },
                "postTime": 1543313628000,
                "replyTime": 1543350764000,
                "replyCount": 5,
                "clazz": {
                    "id": "02fd3297f18e11e8973400163e043b02",
                    "code": "T(2018-2019)-COURSE1-1",
                    "course": {
                        "id": "88ea12bbf18d11e8973400163e043b02",
                        "name": "软件工程专业课1",
                        "textbook": "无",
                        "code": "T(2018-2019)-COURSE1",
                        "type": "",
                        "year": "长期",
                        "semester": "",
                        "englishName": "",
                        "college": "",
                        "credit": 0.0,
                        "weekLearningTime": 0,
                        "weight": "",
                        "preLearning": "",
                        "plan": "",
                        "background": ""
                    },
                    "teachers": [
                        {
                            "id": "6759be4af18d11e8973400163e043b02",
                            "username": "4160102210",
                            "name": "teacher10",
                            "sex": "MALE",
                            "college": "",
                            "department": "",
                            "position": "",
                            "education": "",
                            "pastEvaluation": "",
                            "teachStyle": "",
                            "publish": "",
                            "honor": "",
                            "more": "",
                            "phone": "",
                            "email": ""
                        },
                        {
                            "id": "67a88625f18d11e8973400163e043b02",
                            "username": "4160102211",
                            "name": "teacher11",
                            "sex": "MALE",
                            "college": "",
                            "department": "",
                            "position": "",
                            "education": "",
                            "pastEvaluation": "",
                            "teachStyle": "",
                            "publish": "",
                            "honor": "",
                            "more": "",
                            "phone": "",
                            "email": ""
                        }
                    ],
                    "clazzEnvironments": [
                        {
                            "id": "03295065f18e11e8973400163e043b02",
                            "clazzId": "02fd3297f18e11e8973400163e043b02",
                            "time": "周四0",
                            "place": "教四-100"
                        },
                        {
                            "id": "03387c1ff18e11e8973400163e043b02",
                            "clazzId": "02fd3297f18e11e8973400163e043b02",
                            "time": "周四1",
                            "place": "教四-101"
                        }
                    ],
                    "studentCount": 0,
                    "clazzSetting": {
                        "clazzId": "02fd3297f18e11e8973400163e043b02",
                        "teamAllowed": true,
                        "maxTeamMemberCount": 3,
                        "maxTeamCount": 3
                    }
                },
                "postSetting": {
                    "postId": "13662ae3f1ea11e8973400163e043b02",
                    "postPermission": "TEAM",
                    "teamId": "9302f6d3f18e11e8973400163e043b02"
                }
            },
            {
                "id": "d3533044f24911e8973400163e043b02",
                "title": "4.只有9302f6小组可以看哦",
                "content": "rt",
                "userInfo": {
                    "id": "56969bc9f18d11e8973400163e043b02",
                    "username": "3160102210",
                    "name": "student10"
                },
                "postTime": 1543354752000,
                "replyTime": 1543354752000,
                "replyCount": 0,
                "clazz": {
                    "id": "02fd3297f18e11e8973400163e043b02",
                    "code": "T(2018-2019)-COURSE1-1",
                    "course": {
                        "id": "88ea12bbf18d11e8973400163e043b02",
                        "name": "软件工程专业课1",
                        "textbook": "无",
                        "code": "T(2018-2019)-COURSE1",
                        "type": "",
                        "year": "长期",
                        "semester": "",
                        "englishName": "",
                        "college": "",
                        "credit": 0.0,
                        "weekLearningTime": 0,
                        "weight": "",
                        "preLearning": "",
                        "plan": "",
                        "background": ""
                    },
                    "teachers": [
                        {
                            "id": "6759be4af18d11e8973400163e043b02",
                            "username": "4160102210",
                            "name": "teacher10",
                            "sex": "MALE",
                            "college": "",
                            "department": "",
                            "position": "",
                            "education": "",
                            "pastEvaluation": "",
                            "teachStyle": "",
                            "publish": "",
                            "honor": "",
                            "more": "",
                            "phone": "",
                            "email": ""
                        },
                        {
                            "id": "67a88625f18d11e8973400163e043b02",
                            "username": "4160102211",
                            "name": "teacher11",
                            "sex": "MALE",
                            "college": "",
                            "department": "",
                            "position": "",
                            "education": "",
                            "pastEvaluation": "",
                            "teachStyle": "",
                            "publish": "",
                            "honor": "",
                            "more": "",
                            "phone": "",
                            "email": ""
                        }
                    ],
                    "clazzEnvironments": [
                        {
                            "id": "03295065f18e11e8973400163e043b02",
                            "clazzId": "02fd3297f18e11e8973400163e043b02",
                            "time": "周四0",
                            "place": "教四-100"
                        },
                        {
                            "id": "03387c1ff18e11e8973400163e043b02",
                            "clazzId": "02fd3297f18e11e8973400163e043b02",
                            "time": "周四1",
                            "place": "教四-101"
                        }
                    ],
                    "studentCount": 0,
                    "clazzSetting": {
                        "clazzId": "02fd3297f18e11e8973400163e043b02",
                        "teamAllowed": true,
                        "maxTeamMemberCount": 3,
                        "maxTeamCount": 3
                    }
                },
                "postSetting": {
                    "postId": "d3533044f24911e8973400163e043b02",
                    "postPermission": "TEAM",
                    "teamId": "9302f6d3f18e11e8973400163e043b02"
                }
            }
        ]
    }
}
```

- #### /api/bbs/:id/posts/:id GET 获取指定帖子信息

  ```json
  {
      "meta": {
          "code": 200,
          "success": true,
          "message": "ok"
      },
      "data": {
          "post": {
              "id": "13662ae3f1ea11e8973400163e043b02",
              "title": "title",
              "content": "content here",
              "userInfo": {
                  "id": "56969bc9f18d11e8973400163e043b02",
                  "username": "3160102210",
                  "name": "student10"
              },
              "postTime": 1543313628000,
              "replyTime": 1543350764000,
              "replyCount": 5,
              "clazz": {
                  "id": "02fd3297f18e11e8973400163e043b02",
                  "code": "T(2018-2019)-COURSE1-1",
                  "course": {
                      "id": "88ea12bbf18d11e8973400163e043b02",
                      "name": "软件工程专业课1",
                      "textbook": "无",
                      "code": "T(2018-2019)-COURSE1",
                      "type": "",
                      "year": "长期",
                      "semester": "",
                      "englishName": "",
                      "college": "",
                      "credit": 0.0,
                      "weekLearningTime": 0,
                      "weight": "",
                      "preLearning": "",
                      "plan": "",
                      "background": ""
                  },
                  "teachers": [
                      {
                          "id": "6759be4af18d11e8973400163e043b02",
                          "username": "4160102210",
                          "name": "teacher10",
                          "sex": "MALE",
                          "college": "",
                          "department": "",
                          "position": "",
                          "education": "",
                          "pastEvaluation": "",
                          "teachStyle": "",
                          "publish": "",
                          "honor": "",
                          "more": "",
                          "phone": "",
                          "email": ""
                      },
                      {
                          "id": "67a88625f18d11e8973400163e043b02",
                          "username": "4160102211",
                          "name": "teacher11",
                          "sex": "MALE",
                          "college": "",
                          "department": "",
                          "position": "",
                          "education": "",
                          "pastEvaluation": "",
                          "teachStyle": "",
                          "publish": "",
                          "honor": "",
                          "more": "",
                          "phone": "",
                          "email": ""
                      }
                  ],
                  "clazzEnvironments": [
                      {
                          "id": "03295065f18e11e8973400163e043b02",
                          "clazzId": "02fd3297f18e11e8973400163e043b02",
                          "time": "周四0",
                          "place": "教四-100"
                      },
                      {
                          "id": "03387c1ff18e11e8973400163e043b02",
                          "clazzId": "02fd3297f18e11e8973400163e043b02",
                          "time": "周四1",
                          "place": "教四-101"
                      }
                  ],
                  "studentCount": 0,
                  "clazzSetting": {
                      "clazzId": "02fd3297f18e11e8973400163e043b02",
                      "teamAllowed": true,
                      "maxTeamMemberCount": 3,
                      "maxTeamCount": 3
                  }
              },
              "postSetting": {
                  "postId": "13662ae3f1ea11e8973400163e043b02",
                  "postPermission": "TEAM",
                  "teamId": "9302f6d3f18e11e8973400163e043b02"
              }
          },
          "replies": [
              {
                  "id": "1ef989f4f23811e8973400163e043b02",
                  "postId": "13662ae3f1ea11e8973400163e043b02",
                  "referenceId": null,
                  "content": "this is a good idea",
                  "userInfo": {
                      "id": "56c235a2f18d11e8973400163e043b02",
                      "username": "3160102211",
                      "name": "student11"
                  },
                  "replyTime": 1543347148000,
                  "replyCommentList": [
                      {
                          "id": "a1ac6422f23f11e8973400163e043b02",
                          "replyId": "1ef989f4f23811e8973400163e043b02",
                          "userInfo": {
                              "id": "56c235a2f18d11e8973400163e043b02",
                              "username": "3160102211",
                              "name": "student11"
                          },
                          "content": "this is a good idea",
                          "commentTime": 1543350374000
                      }
                  ]
              },
              {
                  "id": "8a3cb29bf24011e8973400163e043b02",
                  "postId": "13662ae3f1ea11e8973400163e043b02",
                  "referenceId": "1ef989f4f23811e8973400163e043b02",
                  "content": "this is a reference",
                  "userInfo": {
                      "id": "56c235a2f18d11e8973400163e043b02",
                      "username": "3160102211",
                      "name": "student11"
                  },
                  "replyTime": 1543350764000,
                  "replyCommentList": []
              },
              {
                  "id": "8e516e65f23811e8973400163e043b02",
                  "postId": "13662ae3f1ea11e8973400163e043b02",
                  "referenceId": null,
                  "content": "this is a good idea",
                  "userInfo": {
                      "id": "56c235a2f18d11e8973400163e043b02",
                      "username": "3160102211",
                      "name": "student11"
                  },
                  "replyTime": 1543347335000,
                  "replyCommentList": []
              },
              {
                  "id": "ba8672e4f23711e8973400163e043b02",
                  "postId": "13662ae3f1ea11e8973400163e043b02",
                  "referenceId": null,
                  "content": "this is a good idea",
                  "userInfo": {
                      "id": "56c235a2f18d11e8973400163e043b02",
                      "username": "3160102211",
                      "name": "student11"
                  },
                  "replyTime": 1543346980000,
                  "replyCommentList": []
              }
          ]
      }
  }
  ```

#### /api/bbs/:id/posts POST 发布帖子

发送请求

```json

```

获得结果

```json
{
    "meta": {
        "code": 200,
        "success": true,
        "message": "ok"
    },
    "data": {
        "id": "afac0000f25b11e8973400163e043b02",
        "title": "这是我的第一个帖子",
        "content": "rt",
        "userInfo": {
            "id": "56969bc9f18d11e8973400163e043b02",
            "username": "3160102210",
            "name": "student10"
        },
        "postTime": 1543362423000,
        "replyTime": 1543362423000,
        "replyCount": 0,
        "clazz": {
            "id": "02fd3297f18e11e8973400163e043b02",
            "code": "T(2018-2019)-COURSE1-1",
            "course": {
                "id": "88ea12bbf18d11e8973400163e043b02",
                "name": "软件工程专业课1",
                "textbook": "无",
                "code": "T(2018-2019)-COURSE1",
                "type": "",
                "year": "长期",
                "semester": "",
                "englishName": "",
                "college": "",
                "credit": 0.0,
                "weekLearningTime": 0,
                "weight": "",
                "preLearning": "",
                "plan": "",
                "background": ""
            },
            "teachers": [
                {
                    "id": "6759be4af18d11e8973400163e043b02",
                    "username": "4160102210",
                    "name": "teacher10",
                    "sex": "MALE",
                    "college": "",
                    "department": "",
                    "position": "",
                    "education": "",
                    "pastEvaluation": "",
                    "teachStyle": "",
                    "publish": "",
                    "honor": "",
                    "more": "",
                    "phone": "",
                    "email": ""
                },
                {
                    "id": "67a88625f18d11e8973400163e043b02",
                    "username": "4160102211",
                    "name": "teacher11",
                    "sex": "MALE",
                    "college": "",
                    "department": "",
                    "position": "",
                    "education": "",
                    "pastEvaluation": "",
                    "teachStyle": "",
                    "publish": "",
                    "honor": "",
                    "more": "",
                    "phone": "",
                    "email": ""
                }
            ],
            "clazzEnvironments": [
                {
                    "id": "03295065f18e11e8973400163e043b02",
                    "clazzId": "02fd3297f18e11e8973400163e043b02",
                    "time": "周四0",
                    "place": "教四-100"
                },
                {
                    "id": "03387c1ff18e11e8973400163e043b02",
                    "clazzId": "02fd3297f18e11e8973400163e043b02",
                    "time": "周四1",
                    "place": "教四-101"
                }
            ],
            "studentCount": 0,
            "clazzSetting": {
                "clazzId": "02fd3297f18e11e8973400163e043b02",
                "teamAllowed": true,
                "maxTeamMemberCount": 3,
                "maxTeamCount": 3
            }
        },
        "postSetting": {
            "postId": "afac0000f25b11e8973400163e043b02",
            "postPermission": "ALL",
            "teamId": ""
        }
    }
}
```




#### /api/bbs/:id/posts/:id PUT 修改帖子(内容,权限)

#### /api/bbs/:id/posts/:id DELETE 删除帖子

#### /api/bbs/:id/posts/:id/replies GET 获取所有帖子回复(支持过滤信息)

#### /api/bbs/:id/posts/:id/replies POST 发布回帖

发送请求

```json

```

获得结果

```json

```



#### /api/bbs/:id/posts/:id/replies/:reply_id DELETE 删除回帖

#### /api/bbs/:id POST 修改论坛设置

#### /api/bbs/:id/query?q=xxx GET 搜索主题帖(支持过滤信息)







