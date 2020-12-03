package com.lemon.websocket.config;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.lemon.websocket.entity.EventData;
import com.lemon.websocket.listener.DefaultConnectListener;
import com.lemon.websocket.listener.DefaultDisconnectListener;
import com.lemon.websocket.listener.EventDataListener;
import com.lemon.websocket.session.SessionManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @Author lemon
 * @create 2020/11/30
 */
@Slf4j
@Configuration
@Import(SocketProperties.class)
public class SocketConfig {
    @Resource
    private SocketProperties socketProperties;
    @Resource
    private SessionManager sessionManager;

    private SocketIOServer socketIOServer;

    @PostConstruct
    public void register() {
        socketIOServer = this.createSocketServer();
        registerEventListeners(this.socketIOServer);
        socketIOServer.start();
        log.info("websocket server start on {}", socketProperties);

    }
    private SocketIOServer createSocketServer() {
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        config.setHostname(socketProperties.getServer().getHostName());
        config.setPort(socketProperties.getServer().getPort());
        try {
            InputStream stream = new FileInputStream(new File(socketProperties.getServer().getKeyStorePath()));
            config.setKeyStore(stream);
            config.setKeyStorePassword(socketProperties.getServer().getKeyStorePassword());
        } catch (FileNotFoundException e) {
            log.error("KeyStore file not found. path:{}", socketProperties.getServer().getKeyStorePath());
        }
        return new SocketIOServer(config);
    }

    private void registerEventListeners(SocketIOServer server) {
        server.addConnectListener(new DefaultConnectListener(sessionManager));
        server.addEventListener(EventDataListener.EVENT_NAME, EventData.class, new EventDataListener(sessionManager));
        server.addDisconnectListener(new DefaultDisconnectListener(sessionManager));
    }

    @PreDestroy
    public void destroy() {
        if (null != this.socketIOServer) {
            this.socketIOServer.stop();
        }
        if (null != this.socketIOServer) {
            this.socketIOServer.stop();
        }
    }

    public SocketIOClient getSocketClient(UUID sessionId) {
        SocketIOClient socketIOClient = socketIOServer.getClient(sessionId);
        if (socketIOClient == null) {
            log.error("socketIOClient is null");
        }
        return socketIOClient;
    }
}
