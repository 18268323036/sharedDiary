package com.heartBar.sharedDiary.controller;

import com.heartBar.sharedDiary.common.rabbitmq.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangxy 2017/11/23 10:28
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitController {

    @Autowired
    private Sender helloSender1;

    @PostMapping("/hello")
    public void hello() {
        helloSender1.send();
    }
}
