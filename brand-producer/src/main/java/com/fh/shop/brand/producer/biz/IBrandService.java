package com.fh.shop.brand.producer.biz;

import com.fh.brand.api.model.Brand;
import com.fh.common.ServerResponse;

import java.util.List;

/**
 * @author asus
 * @Title: IBrandService
 * @ProjectName brand-producer
 * @Description: TODO
 * @date 2018/11/2117:50
 */
public interface IBrandService {
    ServerResponse<List<Brand>> findBrandList();


    ServerResponse addBrand(Brand brand);

    ServerResponse updateBrand(Brand brand);

    ServerResponse deleteBrand(Integer id);

    ServerResponse<Brand> findBrand(Integer id);

    ServerResponse addBrandCount(Integer id);
}
