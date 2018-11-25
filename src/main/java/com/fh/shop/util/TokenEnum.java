package com.fh.shop.util;

import com.fh.common.IEnum;

/**
 * @author asus
 * @Title: TokenEnum
 * @ProjectName brand-producer
 * @Description: TODO
 * @date 2018/11/2518:53
 */
public enum TokenEnum implements IEnum {
    APP_IS_MISS(401,"头信息丢失"),
    APP_TIME_OUT(402,"访问超时"),
    APP_APPKEY_MISS(403,"appKey不存在"),
    APP_SIGN_MISS(404,"签名失效"),
    APP_NONCE_ERROR(405,"被攻击了"),
    APP_INTERFACE_OUT(406,"访问已达上限");

    private int code;

    private String msg;

    private  TokenEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
