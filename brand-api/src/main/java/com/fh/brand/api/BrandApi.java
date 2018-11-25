package com.fh.brand.api;

import com.fh.brand.api.model.Brand;
import com.fh.common.ServerResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author asus
 * @Title: BrandApi
 * @ProjectName brand-producer
 * @Description: TODO
 * @date 2018/11/2320:13
 */
public interface BrandApi {

    @GetMapping("/brand/list")
    public ServerResponse<List<Brand>> findBrandList();

    @PostMapping("/brand/add")
    public ServerResponse addBrand(Brand brand);

    @PutMapping("/brand/update")
    public ServerResponse updateBrand(@RequestBody Brand brand);

    @DeleteMapping("/brand/{id}")
    public ServerResponse deleteBrand(@PathVariable("id") Integer id);

    @GetMapping("/brand/findBrand")
    public ServerResponse<Brand> findBrand(@RequestParam("id") Integer id);

    @PostMapping("/brand/addBrandCount")
    public ServerResponse addBrandCount(@RequestParam("id") Integer id);

}
