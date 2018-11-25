package com.fh.shop.app.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author asus
 * @Title: IAppMapper
 * @ProjectName book-admin
 * @Description: TODO
 * @date 2018/11/1923:19
 */
public interface IAppMapper {

    @Results({
            @Result(column = "appScret",property = "appScret")
    })
    @Select("select appScret from t_app where appKey=#{value}")
    String getAppScret(String appKey);
}
