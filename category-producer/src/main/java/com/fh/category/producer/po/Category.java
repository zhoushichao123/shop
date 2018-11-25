package com.fh.category.producer.po;

import java.io.Serializable;

/**
 * @author asus
 * @Title: Category
 * @ProjectName brand-producer
 * @Description: TODO
 * @date 2018/11/2216:26
 */
public class Category implements Serializable {

    private static final long serialVersionUID = -1028310194508850290L;
    private Integer cid;
    private String categoryName;
    private Integer cfatherId;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCfatherId() {
        return cfatherId;
    }

    public void setCfatherId(Integer cfatherId) {
        this.cfatherId = cfatherId;
    }
}
