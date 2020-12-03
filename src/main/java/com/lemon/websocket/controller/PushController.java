package com.lemon.websocket.controller;

import com.lemon.websocket.entity.Response;
import com.lemon.websocket.service.PushService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author lemon
 * @create 2020/11/30
 */
@RestController
@RequestMapping("/v1")
public class PushController {
    @Resource
    private PushService pushService;

    @GetMapping("/push")
    public Response pushMessage(
            @RequestParam("message") String message
    ) {
        if (StringUtils.isEmpty(message)) {
            return Response.error(403, "参数不能为空");
        }
        pushService.pushMessage(message);
        return Response.ok();
    }
}
