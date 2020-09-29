package com.csi.dao.impl;

import com.csi.DBUtil.DBUtil;
import com.csi.dao.GoodsDao;
import com.csi.domin.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    @Override
    public int insert(Goods g) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement pstmt = DBUtil.getPstmt(connection,"insert into goods(name,image,price) values(?,?,?)",
                g.getName(),g.getImage(),g.getPrice());
        int i = DBUtil.update(pstmt);
        DBUtil.close(connection,pstmt,null);
        return i;
    }

    @Override
    public List<Goods> selectAll() throws SQLException {
        Connection connection=DBUtil.getConnection();
        PreparedStatement pstmt = DBUtil.getPstmt(connection,"select * from goods");
        ResultSet rs = DBUtil.query(pstmt);
        //创建list
        List<Goods> list = new ArrayList<>();
        while (rs.next()){
            list.add(new Goods(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("image"),
                    rs.getDouble("price")));
        }
        return list;
    }
}
