package com.jiejie.service.impl;

import com.jiejie.dao.ProductDao;
import com.jiejie.domain.Product;
import com.jiejie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    public void save(Product product) {
        productDao.save(product);
    }
}
