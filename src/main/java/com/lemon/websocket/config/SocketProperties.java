package com.lemon.websocket.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author lemon
 * @create 2020/11/30
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "socket")
public class SocketProperties {
    private SocketServer server;

    @Data
    public static class SocketServer{
        private String hostName;

        private Integer port;

        private String KeyStorePath;

        private String KeyStorePassword;
    }

}
