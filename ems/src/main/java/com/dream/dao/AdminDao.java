package com.dream.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dream.entity.Admin;

/**
 * (Admin)表数据库访问层
 *
 * @author dreamheng
 * @since 2019-02-20 16:56:54
 */
public interface AdminDao extends BaseMapper<Admin> {

    /**
     * 根据账号查询
     * */
    Admin selectByUsername(String username);

}