package com.fh.shop.filter;

import com.fh.common.ServerResponse;
import com.fh.shop.app.biz.IAppService;
import com.fh.shop.util.TokenEnum;
import com.fh.util.CheckSumBuilder;
import com.fh.util.SystemUtil;
import com.fh.util.redis.RedisUtil;
import com.google.gson.Gson;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author asus
 * @Title: TokenFilter
 * @ProjectName brand-producer
 * @Description: TODO
 * @date 2018/11/2518:28
 */
public class TokenFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }
    private static final long expire = 60*1000;
    @Resource(name = "appService")
    private IAppService appService;
    @Override
    public Object run() throws ZuulException {
        //获取request
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        //获取header
        String appKey = request.getHeader(SystemUtil.APP_APPKEY);
        String time = request.getHeader(SystemUtil.APP_TIME);
        String nonce = request.getHeader(SystemUtil.APP_NONCE);
        String sign = request.getHeader(SystemUtil.APP_SIGN);
        //判断header是否为空
        if (StringUtils.isEmpty(appKey) || StringUtils.isEmpty(time) || StringUtils.isEmpty(nonce) || StringUtils.isEmpty(sign)){
            ServerResponse error = ServerResponse.error(TokenEnum.APP_IS_MISS);
            //响应
            buildResponse(currentContext, error);
            return null;
        }
        //判断时间
        long timeLong = Long.parseLong(time);
        if (expire+timeLong < System.currentTimeMillis() ){
            ServerResponse error = ServerResponse.error(TokenEnum.APP_TIME_OUT);
            //响应
            buildResponse(currentContext, error);
            return null;
        }
        //判断nonce
        boolean success = RedisUtil.setNxExpire(nonce, nonce, SystemUtil.APP_NONCE_EXPIRE_TIME);
        if (!success){
            ServerResponse error = ServerResponse.error(TokenEnum.APP_NONCE_ERROR);
            //响应
            buildResponse(currentContext, error);
            return null;
        }
        //判断appScret
        String appScret = appService.getAppScret(appKey);
        if (StringUtils.isEmpty(appScret)){
            ServerResponse error = ServerResponse.error(TokenEnum.APP_APPKEY_MISS);
            //响应
            buildResponse(currentContext, error);
            return null;
        }
        //生成签名
        String checkSum = CheckSumBuilder.getCheckSum(appScret, nonce, time);
        //判断签名
        if (!checkSum.equals(sign)){
            ServerResponse error = ServerResponse.error(TokenEnum.APP_APPKEY_MISS);
            //响应
            buildResponse(currentContext, error);
            return null;
        }
        return null;
    }

    private void buildResponse(RequestContext currentContext, ServerResponse error) {
        Gson gson = new Gson();
        currentContext.setSendZuulResponse(false);
        String result = gson.toJson(error);
        currentContext.setResponseBody(result);
        currentContext.getResponse().setContentType("application/json;charset=utf-8");
    }
}
