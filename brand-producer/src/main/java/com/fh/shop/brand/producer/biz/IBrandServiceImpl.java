package com.fh.shop.brand.producer.biz;

import com.fh.brand.api.model.Brand;
import com.fh.common.ServerResponse;
import com.fh.shop.brand.producer.mapper.IBrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author asus
 * @Title: IBrandServiceImpl
 * @ProjectName brand-producer
 * @Description: TODO
 * @date 2018/11/2117:50
 */
@Service("brandService")
@Transactional(rollbackFor = Exception.class)
public class IBrandServiceImpl implements IBrandService {

    @Autowired
    private IBrandMapper brandMapper;

    @Override
    @Transactional(readOnly = true)
    public ServerResponse findBrandList() {
        List<Brand> brandList=brandMapper.findBrandList();
        return ServerResponse.success(brandList);
    }

    @Override
    public ServerResponse addBrand(Brand brand) {
        brandMapper.addBrand(brand);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse updateBrand(Brand brand) {
        brandMapper.updateBrand(brand);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse deleteBrand(Integer id) {
        brandMapper.deleteBrand(id);
        return ServerResponse.success();
    }

    @Override
    public ServerResponse<Brand> findBrand(Integer id) {
       Brand brand = brandMapper.findBrand(id);
        return ServerResponse.success(brand);
    }

    @Override
    public ServerResponse addBrandCount(Integer id) {
        brandMapper.addBrandCount(id);
        return ServerResponse.success();
    }
}
