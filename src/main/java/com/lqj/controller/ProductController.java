package com.lqj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author lqj
 * @Date 2022-10-25 9:15
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @RequestMapping("/info")
    public String info(){
       return "商品列表";
    }

}
