package com.fh.category.producer.biz;

import com.fh.common.ServerResponse;

/**
 * @author asus
 * @Title: ICategoryService
 * @ProjectName brand-producer
 * @Description: TODO
 * @date 2018/11/2216:31
 */
public interface ICategoryService {
    ServerResponse findCategoryListByFatherId(Integer id);
}
