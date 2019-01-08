# NoveduApi设计

[TOC]



## 运行方法

intellij Idea project with maven。

需要tomcat和mysql的支持。

附带可运行的编译后的文件，也可以对线上已部署的版本进行测试：http://api.novedu.cn

## 网站根目录

api.novedu.cn/

## 响应格式

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

## 关于登录

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

## api目录 

省略版本号

- 用户相关
  -  /auth/login POST 用户登录
  -  /auth/register POST 用户注册
  -  /auth/change-password POST 修改用户密码
  -  /users 用户信息
- 课程信息(包括课程基本信息，教学大纲，教师信息)
  -  /classes POST 添加课程
  -  /classes GET 获取所有课程信息
  -  /classes/:id GET 获取指定课程信息
  -  /classes/students POST 添加学生
- 课程组队
  -  /classes/:id/teams GET 获取所有队伍信息（支持过滤信息）
  -  /teams/:id GET 获取指定队伍信息
  -  /classes/:id/teams POST 新建一个队伍
  -  /teams/:id DELETE 删除队伍
  -  /teams/:id PUT 更新队伍信息
  -  /teams/:id/request POST 加入某只队伍
  -  /teams/:id/request GET 获取加入队伍信息
  -  /teams/:id/request/handler POST 处理请求信息
- 课程论坛
  -  /bbs/:id/posts GET 获取所有帖子信息(支持过滤信息)
  -  /posts/:id GET 获取指定帖子信息
  -  /bbs/:id/posts POST 发布帖子
  -  /posts/:id PUT 修改帖子(内容,权限)
  -  /posts/:id DELETE 删除帖子
  -  /posts/:id/replies GET 获取所有帖子回复(支持过滤信息)
  -  /posts/:id/replies POST 发布回帖
  -  /replies/:reply_id DELETE 删除回帖
  -  /replies/:reply-id/comments GET 获得评论
  -  /replies/:reply-id/comments POST 发布评论
  -  /comments/:comment-id DELETE 删除评论
  -  /bbs/:id POST 修改论坛设置
  -  /bbs/:id/query?q=xxx GET 搜索主题帖(支持过滤信息)
- 课程资料
  -  /classes/:id/resources GET 获取课程资源列表(支持过滤信息)
  -  /classes/:id/resources/:id GET 获取课程资源详细信息
  -  /classes/:id/resources POST 添加课程资源
  -  /classes/:id/resources/:id DELETE 删除资源
- 消息系统
  -  /messages GET 消息列表 获取消息列表(支持过滤信息)
  -  /messages/:id GET 获得指定消息信息
  -  /messages/:id POST 响应消息 
  -  /messages/:id DELETE 删除消息
  - 

## Ⅴ过滤信息

```
?limit=10：指定返回记录的数量
?offset=10：指定返回记录的开始位置。
?page=2&per_page=100：指定第几页，以及每页的记录数。
?orderby=name&order=asc：指定返回结果按照哪个属性排序，以及排序顺序。
```


