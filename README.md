# 简介
项目使用netty-socketio框架实现了websocket长连接；

## 接口
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
