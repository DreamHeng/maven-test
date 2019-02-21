package com.dream.service;

import com.dream.entity.Admin;

import java.util.List;

public interface AdminService {
    /**
     * 登录
     * */
    Admin login(String username);

    /**
     * 查询所有
     * */
    List<Admin> selectAll();
    /**
     * 添加admin
     * */
    boolean insertAdmin(Admin admin);
    /**
     * 根据id查询一个
     * */
    Admin selectById(Integer id);
    /**
     * 根据id修改
     * */
    boolean updateById(Admin admin);
    /**
     * 根据id删除
     * */
    boolean deleteById(Integer id);
}
