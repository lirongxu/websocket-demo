package com.lemon.websocket.service.impl;

import com.corundumstudio.socketio.SocketIOClient;
import com.lemon.websocket.config.SocketConfig;
import com.lemon.websocket.service.PushService;
import com.lemon.websocket.session.SessionManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @Author lemon
 * @create 2020/11/30
 */
@Slf4j
@Service
public class PushMessageImpl implements PushService {
    @Resource
    private SessionManager sessionManager;
    @Resource
    private SocketConfig socketConfig;

    @Override
    public void pushMessage(String message) {
        List<UUID> sessionList = sessionManager.getSessionList();

        sessionList.forEach(session -> {
            log.info("send message:{}  {}", message, session);
            SocketIOClient socketIOClient = socketConfig.getSocketClient(session);
            socketIOClient.sendEvent("msg", message);

        });
    }
}
