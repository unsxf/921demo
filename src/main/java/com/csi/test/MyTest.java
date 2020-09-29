package com.csi.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.csi.dao.EmpDao;
import com.csi.dao.impl.DeptDapImpl;
import com.csi.dao.impl.EmpDaoImpl;
import com.csi.domin.Dept;
import com.csi.domin.Emp;

import java.sql.SQLException;
import java.util.List;

public class MyTest {
    public static void main(String[] args) throws SQLException {
        EmpDao dao = new EmpDaoImpl();
        List<Emp> emps = dao.selectAll();
        String s = JSON.toJSONString(emps, SerializerFeature.WriteNullNumberAsZero,SerializerFeature.PrettyFormat);
        System.out.println(s);
    }
}
