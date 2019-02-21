package com.dreamheng.controller;

import com.dreamheng.entity.Admin;
import com.dreamheng.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/test")
    public @ResponseBody List test(){
        List<Admin> list = adminService.selectAll();
        return list;
    }
}
