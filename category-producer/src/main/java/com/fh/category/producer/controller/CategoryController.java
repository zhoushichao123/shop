package com.fh.category.producer.controller;

import com.fh.category.producer.biz.ICategoryService;
import com.fh.common.ServerResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author asus
 * @Title: CategoryController
 * @ProjectName brand-producer
 * @Description: TODO
 * @date 2018/11/2216:26
 */
@RestController
public class CategoryController {

    @Resource(name = "categoryService")
    private ICategoryService categoryService;

    @GetMapping("/category/listByFatherId")
    public ServerResponse findCategoryListByFatherId(Integer id){
        return categoryService.findCategoryListByFatherId(id);
    }


}
