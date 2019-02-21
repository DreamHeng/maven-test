package com.dream.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("admin")
public class Admin implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    
    private String username;
    
    private String password;

    private Integer age;

    private Double salary;
}