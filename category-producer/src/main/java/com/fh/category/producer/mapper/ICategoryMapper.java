package com.fh.category.producer.mapper;

import com.fh.category.producer.po.Category;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author asus
 * @Title: ICategoryMapper
 * @ProjectName brand-producer
 * @Description: TODO
 * @date 2018/11/2216:33
 */
public interface ICategoryMapper {

    @Results({
            @Result(column ="cid",property = "cid"),
            @Result(column ="categoryName",property = "categoryName"),
            @Result(column ="cfatherId",property = "cfatherId")
    })
    @Select("select cid,categoryName,cfatherId from t_category where cfatherId=#{value}")
    List<Category> findCategoryListByFatherId(Integer id);
}
