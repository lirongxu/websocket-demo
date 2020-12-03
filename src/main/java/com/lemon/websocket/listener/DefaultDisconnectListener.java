package com.lemon.websocket.listener;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.lemon.websocket.session.SessionManager;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author lemon
 * @create 2020/11/30
 */
@Slf4j
public class DefaultDisconnectListener implements DisconnectListener {
    private SessionManager sessionManager;

    public DefaultDisconnectListener(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void onDisconnect(SocketIOClient socketIOClient) {

        log.info("{} disconnected", socketIOClient.getSessionId());
        sessionManager.removeSession(socketIOClient.getSessionId());
    }
}
