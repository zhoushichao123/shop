package com.fh.shop.brand.producer.mapper;

import com.fh.brand.api.model.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author asus
 * @Title: IBrandMapper
 * @ProjectName brand-producer
 * @Description: TODO
 * @date 2018/11/2117:55
 */
public interface IBrandMapper {

    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "brandName",property = "brandName"),
            @Result(column = "logo",property = "logo"),
            @Result(column = "brandDescribe",property = "brandDescribe"),
            @Result(column = "brandCount",property = "brandCount")
    })
    @Select("select id,brandName,logo,brandDescribe,brandCount from t_brand")
    List<Brand> findBrandList();


    @Insert("insert into t_brand(brandName,logo,brandDescribe) values(#{brandName},#{logo},#{brandDescribe})")
    void addBrand(Brand brand);


    @Update("update t_brand set brandName=#{brandName},logo=#{logo},brandDescribe=#{brandDescribe} where id=#{id}")
    void updateBrand(Brand brand);

    @Delete("delete from t_brand where id=#{value}")
    void deleteBrand(Integer id);

    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "brandName",property = "brandName"),
            @Result(column = "logo",property = "logo"),
            @Result(column = "brandDescribe",property = "brandDescribe"),
            @Result(column = "brandCount",property = "brandCount")
    })
    @Select("select id,brandName,logo,brandDescribe,brandCount from t_brand where id=#{value}")
    Brand findBrand(Integer id);

    @Update("update t_brand set brandCount=brandCount+1 where id=#{value}")
    void addBrandCount(Integer id);
}
