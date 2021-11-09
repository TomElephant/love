package com.love.loveme.controller;

import com.love.loveme.service.LoveService;
import com.love.loveme.vo.Lover;
import com.love.loveme.vo.ResultLove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zlx
 * @ClassName MyLove.java
 * @Description TODO
 * @createTime 2021年11月05日 16:43:00
 */
@RestController
@RequestMapping("/mylove")
public class MyLove {

    @Autowired
    private LoveService loveService;

    @GetMapping(value = "/love")
    private ResultLove getMyLove() {


        return loveService.getMyLove();

    }

    @RequestMapping("/initLove")
    private Boolean initLove() {


        return loveService.initLove();

    }


}
