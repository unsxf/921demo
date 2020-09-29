package com.csi.dao;

import com.csi.domin.Admin;

public interface AdminDao {
    //根据账号和密码查询管理员信息
    Admin selectByNameAndPassword(String account, String password);
}
