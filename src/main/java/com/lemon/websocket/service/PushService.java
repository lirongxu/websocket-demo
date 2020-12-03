package com.lemon.websocket.service;

/**
 * @Author lemon
 * @create 2020/11/30
 */
public interface PushService {

    /**
     * 往前端推送数据
     * @param message
     */
    void pushMessage(String message);
}
