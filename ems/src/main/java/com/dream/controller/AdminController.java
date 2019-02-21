package com.dream.controller;

import com.dream.entity.Admin;
import com.dream.service.AdminService;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String login(String username,String password,Map map){
        Admin admin = adminService.login(username);
        if(admin!=null){
            if(admin.getPassword().equals(password)){
                List<Admin> list = adminService.selectAll();
                map.put("list",list);
                return "emplist";
            }
        }
        map.put("tips","用户名或密码错误");
        return "login";
    }

    @RequestMapping("/addAdmin")
    public String addAdmin(Admin admin,Map map){
        boolean b = adminService.insertAdmin(admin);
        if(b){
            List<Admin> list = adminService.selectAll();
            map.put("list",list);
            return "emplist";
        }
        return "addEmp";
    }

    @RequestMapping("/deleteAdmin")
    public String deleteAdmin(Integer id,Map map){
        boolean b = adminService.deleteById(id);
        if(b){
            List<Admin> list = adminService.selectAll();
            map.put("list",list);
            return "emplist";
        }
        return "emplist";
    }

    @RequestMapping("/selectById")
    public String selectById(Integer id,Map map){
        Admin admin = adminService.selectById(id);
        map.put("admin",admin);
        return "updateEmp";
    }
    @RequestMapping("/updateAdmin")
    public String updateAdmin(Admin admin,Map map){
        boolean b = adminService.updateById(admin);
        if(b){
            List<Admin> list = adminService.selectAll();
            map.put("list",list);
            return "emplist";
        }
        return "updateEmp";
    }

    @Autowired
    private Producer producer;
    @RequestMapping("/getImage")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
        String text = producer.createText();
        session.setAttribute("code",text);
        BufferedImage image = producer.createImage(text);
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    @RequestMapping("/yanzheng")
    public @ResponseBody boolean yanzheng(String code,HttpSession session){
        String text = (String) session.getAttribute("code");
        if(text.equals(code)){
            return true;
        }else {
            return false;
        }
    }

    @RequestMapping("/checkUser")
    public @ResponseBody boolean check(String username){
        Admin admin = adminService.login(username);
        if(admin!=null){
            return false;
        }
        return true;
    }

    @RequestMapping("/regist")
    public String regist(Admin admin){
        boolean b = adminService.insertAdmin(admin);
        if(b){
            return "login";
        }
        return "regist";
    }

}
