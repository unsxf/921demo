package com.csi.service;

import com.csi.DBUtil.Page;
import com.csi.domin.Emp;

import java.sql.SQLException;
import java.util.List;

public interface EmpService {
    //新增员工
    String addEmp(Emp emp) throws SQLException;
    //查询所有员工
    List<Emp> findAll() throws SQLException;
    //查询所有领导
    List<Emp> findAllManager() throws SQLException;
    //根据员工编号查询
    Emp findById(String id);
    //修改员工信息的方法
    String changeEmp(Emp emp);
    //删除员工信息的方法
    String removeEmp(int id);
    //分页查询操作
    Page<Emp> findByPage(int pageNum,int pageSize) throws SQLException;
}
