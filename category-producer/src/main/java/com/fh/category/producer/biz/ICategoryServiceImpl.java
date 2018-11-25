package com.fh.category.producer.biz;

import com.fh.category.producer.mapper.ICategoryMapper;
import com.fh.category.producer.po.Category;
import com.fh.common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author asus
 * @Title: ICategoryServiceImpl
 * @ProjectName brand-producer
 * @Description: TODO
 * @date 2018/11/2216:31
 */
@Service("categoryService")
public class ICategoryServiceImpl implements ICategoryService {

    @Autowired
    private ICategoryMapper categoryMapper;

    @Override
    public ServerResponse findCategoryListByFatherId(Integer id) {
      List<Category> categoryList = categoryMapper.findCategoryListByFatherId(id);
        return ServerResponse.success(categoryList);
    }
}
