package com.lemon.websocket;

import com.lemon.websocket.config.SocketProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Author lemon
 * @create 2020/11/30
 */
@Slf4j
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConfigTest {
    @Resource
    private SocketProperties socketProperties;

    @Test
    public void test(){
        log.info("socketProperties:{}", socketProperties);
    }
}
