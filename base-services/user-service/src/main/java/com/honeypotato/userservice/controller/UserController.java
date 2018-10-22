package com.honeypotato.userservice.controller;

import com.honeypotato.common.aop.ReqLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lenovo on 2018/3/27.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @GetMapping(value = "/{userId}")
    @ReqLog
    public String get(@PathVariable long userId) {
        return "hello " + userId;
    }
}
