package com.honeypotato.auth.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * Created by Lenovo on 2018/3/27.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private DiscoveryClient client;

    @GetMapping
    @RequestMapping(value = "/{userId}")
    public String get(@PathVariable long userId) {
        return "hello " + userId;
    }
}
