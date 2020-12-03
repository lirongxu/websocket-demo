package com.lemon.websocket.entity;

import lombok.Data;

/**
 * @Author lemon
 * @create 2020/11/30
 */
@Data
public class Response {

    private Integer code;

    private String msg;

    private Response() {
        this.code = 200;
        this.msg = "ok";
    }

    private Response(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Response ok() {
        return new Response();
    }

    public static Response error(Integer code, String msg) {
        return new Response(code, msg);
    }
}
