package com.csi.service.Impl;


import com.csi.dao.GoodsDao;
import com.csi.dao.impl.GoodsDaoImpl;
import com.csi.domin.Goods;
import com.csi.service.GoodsService;

import java.sql.SQLException;
import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    private GoodsDao dao;
    public  GoodsServiceImpl(){ this.dao = new GoodsDaoImpl() {
    }; }
    @Override
    public String addGoods(Goods g) {
        return this.dao.insert(g)>0?"添加成功":"添加失败";
    }

    @Override
    public List<Goods> findAll() throws SQLException {
        return this.dao.selectAll();
    }
}
