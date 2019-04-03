package com.jiejie.controller;

import com.jiejie.domain.Product;
import com.jiejie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll")
    public String findAll(Model model) throws Exception {

        List<Product> products = productService.findAll();

        model.addAttribute("productList", products);
        return "product-list";
    }

    @RequestMapping("/save")
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll";
    }
}
