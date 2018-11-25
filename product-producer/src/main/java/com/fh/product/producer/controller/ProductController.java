package com.fh.product.producer.controller;

import com.fh.common.ServerResponse;
import com.fh.product.producer.biz.IProductService;
import com.fh.product.producer.po.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author asus
 * @Title: ProductController
 * @ProjectName brand-producer
 * @Description: TODO
 * @date 2018/11/2216:01
 */
@RestController
public class ProductController {

    @Resource(name = "productService")
    private IProductService productService;

    @PostMapping("/product/add")
    public ServerResponse addProduct(Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/product/findProduct")
    public ServerResponse findProduct(){
        return productService.findProduct();
    }

}
