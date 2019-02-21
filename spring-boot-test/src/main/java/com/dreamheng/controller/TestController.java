package com.dreamheng.controller;

import com.dreamheng.entity.Admin;
import com.dreamheng.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    @Autowired
    private AdminService adminService;
    @RequestMapping("/test")
    public String test(Map map){
        List<Admin> list = adminService.selectAll();
        map.put("list",list);
        return "test";
    }

}
