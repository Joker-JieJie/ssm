package com.jiejie.service;

import com.jiejie.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    //    查詢所有產品
    public List<Product> findAll() throws Exception;

    //    保存
    public void save(Product product);
}
