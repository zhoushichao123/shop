package com.fh.product.producer.mapper;

import com.fh.product.producer.po.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author asus
 * @Title: IProductMapper
 * @ProjectName brand-producer
 * @Description: TODO
 * @date 2018/11/2216:06
 */
public interface IProductMapper {
    @Insert("insert into t_goods(goodsName,goodsImg,goodsPrice,inventory,brandId,category1,category2,category3,categoryInfo) values (#{goodsName},#{goodsImg},#{goodsPrice},#{inventory},#{brandId},#{category1.cid},#{category2.cid},#{category3.cid},#{categoryInfo})")
    void addProduct(Product product);

    @Select("select gid,goodsName,goodsImg,goodsPrice,inventory,brandId ,categoryInfo from t_goods")
    List<Product> findProduct();

}
