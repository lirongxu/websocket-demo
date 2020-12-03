package com.lemon.websocket.session;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author lemon
 * @create 2020/11/30
 */
@Slf4j
@Component
public class SessionManager {
    private final Lock sessionLock = new ReentrantLock();
    private List<UUID> sessionList = new ArrayList<>();

    public void addSession(UUID sessionId) {
        sessionLock.lock();
        try {
            sessionList.add(sessionId);
        } finally {
            sessionLock.unlock();
        }
    }

    public void removeSession(UUID sessionId) {
        sessionLock.lock();
        try {
            sessionList.remove(sessionId);
        } finally {
            sessionLock.unlock();
        }
    }

    public List<UUID> getSessionList(){
        return sessionList;
    }
}
