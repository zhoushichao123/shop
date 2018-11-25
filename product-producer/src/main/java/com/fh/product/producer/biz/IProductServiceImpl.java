package com.fh.product.producer.biz;

import com.fh.brand.api.BrandApi;
import com.fh.brand.api.model.Brand;
import com.fh.common.ServerResponse;
import com.fh.product.producer.mapper.IProductMapper;
import com.fh.product.producer.po.Product;
import com.fh.product.producer.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author asus
 * @Title: IProductServiceImpl
 * @ProjectName brand-producer
 * @Description: TODO
 * @date 2018/11/2216:04
 */
@Service("productService")
@Transactional(rollbackFor = Exception.class)
public class IProductServiceImpl implements IProductService {

    @Autowired
    private IProductMapper productMapper;

    @Autowired
    private BrandApi brandApi;

    @Override
    public ServerResponse addProduct(Product product) {
        productMapper.addProduct(product);
        ServerResponse response = brandApi.addBrandCount(product.getBrandId());
        return response;
    }

    @Override
    public ServerResponse findProduct() {
        List<Product> productList = productMapper.findProduct();
        List<ProductVo> productVoList = new ArrayList<>();
        for (Product product : productList) {
            ProductVo productVo = new ProductVo();
            productVo.setGoodsName(product.getGoodsName());
            productVo.setGoodsPrice(product.getGoodsPrice());
            ServerResponse<Brand> response = brandApi.findBrand(product.getBrandId());
            Brand brand = response.getData();
            String brandName = brand.getBrandName();
            productVo.setBrandName(brandName);
            productVoList.add(productVo);
        }
        return ServerResponse.success(productVoList);
    }
}
