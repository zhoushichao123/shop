package com.fh.brand.api.model;

import java.io.Serializable;

/**
 * @author asus
 * @Title: Brand
 * @ProjectName brand-producer
 * @Description: TODO
 * @date 2018/11/2320:17
 */
public class Brand implements Serializable {
    private static final long serialVersionUID = -3131063900477582044L;
    private Integer id;

    private String brandName;

    private String logo;

    private String brandDescribe;

    private Integer brandCount;

    public Integer getBrandCount() {
        return brandCount;
    }

    public void setBrandCount(Integer brandCount) {
        this.brandCount = brandCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBrandDescribe() {
        return brandDescribe;
    }

    public void setBrandDescribe(String brandDescribe) {
        this.brandDescribe = brandDescribe;
    }
}
