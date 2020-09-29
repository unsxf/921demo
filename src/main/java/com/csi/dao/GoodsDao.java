package com.csi.dao;

import com.csi.domin.Goods;
import com.csi.servlet.GoodsServlet;

import java.sql.SQLException;
import java.util.List;

public interface GoodsDao {
    int insert(Goods g);
    List<Goods> selectAll() throws SQLException;
}
