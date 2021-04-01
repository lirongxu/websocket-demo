package com.lemon.websocket.listener;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.DataListener;
import com.lemon.websocket.entity.EventData;
import com.lemon.websocket.entity.Response;
import com.lemon.websocket.session.SessionManager;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author lemon
 * @create 2020/11/30
 */
@Slf4j
public class EventDataListener implements DataListener<EventData> {
    public static String EVENT_NAME = "event";

    private SessionManager sessionManager;

    public EventDataListener(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void onData(SocketIOClient socketIOClient, EventData eventData, AckRequest ackRequest) throws Exception {
        log.info("接收到客户端消息:{}", eventData);
        sessionManager.addSession(socketIOClient.getSessionId());

        socketIOClient.sendEvent(EVENT_NAME, Response.ok());
    }
}
