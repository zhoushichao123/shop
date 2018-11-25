package com.fh.product.producer.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fh.util.BigDecimalJackson;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author asus
 * @Title: ProductVo
 * @ProjectName brand-producer
 * @Description: TODO
 * @date 2018/11/2414:33
 */
public class ProductVo implements Serializable {
    private static final long serialVersionUID = 2277552734505619600L;
    private String goodsName;

    @JsonSerialize(using =BigDecimalJackson.class )
    private BigDecimal goodsPrice;

    public String brandName;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
