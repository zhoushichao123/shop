package com.fh.shop.protal.controller;

import com.fh.common.ServerResponse;
import com.fh.util.HTTPClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author asus
 * @Title: ProductController
 * @ProjectName brand-producer
 * @Description: TODO
 * @date 2018/11/2223:40
 */
@Controller
public class ProductController {

    public static final String URL="http://localhost:8888/";


    @GetMapping("/brand/findBrandAllList")
    @ResponseBody
    public ServerResponse findBrandList(){
        ServerResponse response = HTTPClient.getHttp(URL + "fh-shop-brand-producer/brand/list", null, null,true);
        return response;
    }

    @GetMapping("/category/findCategoryListByPid")
    @ResponseBody
    public ServerResponse findCategoryListByPid(Integer id){
        Map<String,String> map =new HashMap<>();
        map.put("id",id+"");
        ServerResponse response = HTTPClient.getHttp(URL + "fh-shop-category-producer/category/listByFatherId", map, null,true);
        return response;
    }

    @PostMapping("/goods/addGoods")
    @ResponseBody
    public ServerResponse addGoods(@RequestParam Map product){
        ServerResponse response = HTTPClient.sendPost(URL + "fh-shop-product-producer/product/add", product, null,true);
        return response;
    }

    @GetMapping("/product/findProductList")
    @ResponseBody
    public ServerResponse findProductList(){
        ServerResponse response = HTTPClient.getHttp(URL + "fh-shop-product-producer/product/findProduct", null, null,true);
        return response;
    }


}
