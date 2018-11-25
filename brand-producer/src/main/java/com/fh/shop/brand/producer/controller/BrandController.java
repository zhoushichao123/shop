package com.fh.shop.brand.producer.controller;

import com.fh.brand.api.BrandApi;
import com.fh.brand.api.model.Brand;
import com.fh.common.ServerResponse;
import com.fh.shop.brand.producer.biz.IBrandService;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author asus
 * @Title: BrandController
 * @ProjectName brand-producer
 * @Description: TODO
 * @date 2018/11/2117:39
 */
@RestController
public class BrandController implements BrandApi {

    @Resource(name = "brandService")
    private IBrandService brandService;


    @Override
    public ServerResponse<List<Brand>> findBrandList() {
        return brandService.findBrandList();
    }

    @Override
    public ServerResponse addBrand(Brand brand) {
        return brandService.addBrand(brand);
    }

    @Override
    public ServerResponse updateBrand(Brand brand) {
        return brandService.updateBrand(brand);
    }

    @Override
    public ServerResponse deleteBrand(@RequestParam("id") Integer id) {
        return brandService.deleteBrand(id);
    }

    @Override
    public ServerResponse<Brand> findBrand(@RequestParam("id") Integer id) {
        return brandService.findBrand(id);
    }

    @Override
    public ServerResponse addBrandCount(@RequestParam("id")Integer id) {

        return brandService.addBrandCount(id);
    }
}
