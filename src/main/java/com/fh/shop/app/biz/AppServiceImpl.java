package com.fh.shop.app.biz;

import com.fh.shop.app.mapper.IAppMapper;
import com.fh.util.redis.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author asus
 * @Title: AppServiceImpl
 * @ProjectName book-admin
 * @Description: TODO
 * @date 2018/11/1923:15
 */
@Service("appService")
public class AppServiceImpl implements IAppService {

    @Resource
    private IAppMapper appMapper;

    @Override
    public String getAppScret(String appKey) {
        String appScret = RedisUtil.get(appKey);
        if (StringUtils.isNotEmpty(appScret)){
            return appScret;
        }
        appScret = appMapper.getAppScret(appKey);
        if (StringUtils.isEmpty(appScret)){
            return "";
        }
        RedisUtil.set(appKey,appScret);
        return  appScret;
    }
}
