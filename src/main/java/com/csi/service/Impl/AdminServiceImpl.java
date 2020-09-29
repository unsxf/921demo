package com.csi.service.Impl;

import com.csi.dao.AdminDao;
import com.csi.dao.impl.AdminDapImpl;
import com.csi.domin.Admin;
import com.csi.service.AdminService;

public class AdminServiceImpl implements AdminService {
    private AdminDao dao;
    public AdminServiceImpl(){
        this.dao = new AdminDapImpl();
    }
    @Override
    public Admin login(String account, String password) {
        return this.dao.selectByNameAndPassword(account,password);
    }
}
