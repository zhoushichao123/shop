package com.fh.product.producer.biz;

import com.fh.common.ServerResponse;
import com.fh.product.producer.po.Product;

/**
 * @author asus
 * @Title: IProductService
 * @ProjectName brand-producer
 * @Description: TODO
 * @date 2018/11/2216:04
 */
public interface IProductService {
    ServerResponse addProduct(Product product);

    ServerResponse findProduct();


}
