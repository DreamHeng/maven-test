package com.dreamheng.service.impl;

import com.dreamheng.dao.AdminDao;
import com.dreamheng.entity.Admin;
import com.dreamheng.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public List<Admin> selectAll() {
        return adminDao.selectAll();
    }
}
