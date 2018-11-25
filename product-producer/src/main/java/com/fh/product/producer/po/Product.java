package com.fh.product.producer.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fh.brand.api.model.Brand;
import com.fh.util.BigDecimalJackson;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author asus
 * @Title: Product
 * @ProjectName brand-producer
 * @Description: TODO
 * @date 2018/11/2215:54
 */
public class Product implements Serializable {
    private static final long serialVersionUID = -5151500677712489940L;
    private Integer gid;
    private String goodsName;
    private String goodsImg;

    private List<String> oldPath=new ArrayList<>();

    @JsonSerialize(using =BigDecimalJackson.class )
    private BigDecimal goodsPrice;

    private Integer inventory;
    private Integer brandId;
    private BigDecimal minGoodsPrice;
    private BigDecimal maxGoodsPrice;
    private Integer minInventory;
    private Integer maxInventory;
   private Category category1=new Category();
    private Category category2=new Category();
    private Category category3=new Category();
    private  String categoryInfo;

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Category getCategory1() {
        return category1;
    }

    public void setCategory1(Category category1) {
        this.category1 = category1;
    }

    public Category getCategory2() {
        return category2;
    }

    public void setCategory2(Category category2) {
        this.category2 = category2;
    }

    public Category getCategory3() {
        return category3;
    }

    public void setCategory3(Category category3) {
        this.category3 = category3;
    }


    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public List<String> getOldPath() {
        return oldPath;
    }

    public void setOldPath(List<String> oldPath) {
        this.oldPath = oldPath;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public BigDecimal getMinGoodsPrice() {
        return minGoodsPrice;
    }

    public void setMinGoodsPrice(BigDecimal minGoodsPrice) {
        this.minGoodsPrice = minGoodsPrice;
    }

    public BigDecimal getMaxGoodsPrice() {
        return maxGoodsPrice;
    }

    public void setMaxGoodsPrice(BigDecimal maxGoodsPrice) {
        this.maxGoodsPrice = maxGoodsPrice;
    }

    public Integer getMinInventory() {
        return minInventory;
    }

    public void setMinInventory(Integer minInventory) {
        this.minInventory = minInventory;
    }

    public Integer getMaxInventory() {
        return maxInventory;
    }

    public void setMaxInventory(Integer maxInventory) {
        this.maxInventory = maxInventory;
    }

    public String getCategoryInfo() {
        return categoryInfo;
    }

    public void setCategoryInfo(String categoryInfo) {
        this.categoryInfo = categoryInfo;
    }
}
