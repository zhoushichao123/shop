package com.fh.shop.config;

import com.fh.shop.filter.TokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author asus
 * @Title: ToTokenFilter
 * @ProjectName brand-producer
 * @Description: TODO
 * @date 2018/11/2518:29
 */
@Configuration
public class ToTokenFilter {

    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }

}
