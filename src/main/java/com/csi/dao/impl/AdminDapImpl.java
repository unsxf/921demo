package com.csi.dao.impl;

import com.csi.DBUtil.DBUtil;
import com.csi.dao.AdminDao;
import com.csi.domin.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDapImpl implements AdminDao {
    @Override
    public Admin selectByNameAndPassword(String account, String password) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = DBUtil.getPstmt(conn,"select * feom admin where account=? and password =?",
                account,password);
        //执行sql语句
        ResultSet rs = DBUtil.query(pstmt);
        //判断是否有结果
        try {
            if (rs.next()){
                return new Admin(rs.getInt("id"),
                        rs.getString("accound"),
                        rs.getString("password"),
                        rs.getString("name"));
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        return null;
        }finally {
            DBUtil.close(conn,pstmt,rs);
        }
    }
}
