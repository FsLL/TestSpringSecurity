package com.lqj.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lqj
 * @Date 2022-10-24 16:16
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello")
    @PreAuthorize("hasAuthority('test')")
    public String test(){
        return "hello";
    }

}
