package com.fh.brand.api;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author asus
 * @Title: BrandApiFeignClient
 * @ProjectName brand-producer
 * @Description: TODO
 * @date 2018/11/2320:24
 */
@FeignClient("fh-shop-brand-producer")
public interface BrandApiFeignClient extends BrandApi{
}
