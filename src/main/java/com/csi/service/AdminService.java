package com.csi.service;

import com.csi.domin.Admin;

public interface AdminService {
    Admin login(String account,String password);
}
