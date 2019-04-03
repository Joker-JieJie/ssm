package com.jiejie.dao;

import com.jiejie.domain.Product;

import java.util.List;

public interface ProductDao {

    //查詢所有
    public List<Product> findAll() throws Exception;

    //保存
    public void save(Product product);
}
