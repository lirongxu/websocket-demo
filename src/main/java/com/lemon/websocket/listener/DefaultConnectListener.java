package com.lemon.websocket.listener;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.lemon.websocket.session.SessionManager;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author lemon
 * @create 2020/11/30
 */
@Slf4j
public class DefaultConnectListener implements ConnectListener {

    private SessionManager sessionManager;

    public DefaultConnectListener(SessionManager sessionManager) {

        this.sessionManager = sessionManager;
    }

    @Override
    public void onConnect(SocketIOClient socketIOClient) {
        log.info("{} connected", socketIOClient.getSessionId());
    }
}
