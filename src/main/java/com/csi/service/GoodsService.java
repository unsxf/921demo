package com.csi.service;

import com.csi.domin.Goods;

import java.sql.SQLException;
import java.util.List;

public interface GoodsService {
    String addGoods(Goods g);
    List<Goods> findAll() throws SQLException;
}
