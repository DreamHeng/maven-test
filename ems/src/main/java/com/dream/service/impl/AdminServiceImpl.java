package com.dream.service.impl;

import com.dream.dao.AdminDao;
import com.dream.entity.Admin;
import com.dream.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;
    @Override
    public Admin login(String username) {
        Admin admin = adminDao.selectByUsername(username);
        return admin;
    }

    @Override
    public List<Admin> selectAll() {
        List<Admin> list = adminDao.selectList(null);
        return list;
    }

    @Override
    @Transactional
    public boolean insertAdmin(Admin admin) {
        int i = adminDao.insert(admin);
        if(i==1){
            return true;
        }
        return false;
    }

    @Override
    public Admin selectById(Integer id) {
        return adminDao.selectById(id);
    }

    @Override
    @Transactional
    public boolean updateById(Admin admin) {
        int i = adminDao.updateById(admin);
        if(i==1){
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteById(Integer id) {
        int i = adminDao.deleteById(id);
        if(i==1){
            return true;
        }
        return false;
    }
}
