# 简介
项目使用netty-socketio框架实现了websocket长连接；

## 前端页面
**http://127.0.0.1:8080/index.html**

## 后端往前端推送数据API
**http://127.0.0.1:8080/v1/push?message=demo**

**请求类型：**`GET` 
*/v1/push*
- message 消息
```
{
    "code": 200,
    "msg": "ok"
}
```
