/** 
 * <pre>项目名称:shop-admin2 
 * 文件名称:SystemEnum.java 
 * 包名:com.fh.shop.admin.common 
 * 创建日期:2018年10月19日下午2:02:36 
 * Copyright (c) 2018, 1145159483@qq.com All Rights Reserved.</pre> 
 */  
package com.fh.common;

/** 
 * <pre>项目名称：shop-admin2    
 * 类名称：SystemEnum    
 * 类描述：    
 * 创建人：高兵 1145159483@qq.com    
 * 创建时间：2018年10月19日 下午2:02:36    
 * 修改人：高兵 1145159483@qq.com     
 * 修改时间：2018年10月19日 下午2:02:36    
 * 修改备注：       
 * @version </pre>    
 */
public enum SystemEnum implements IEnum{

	OK(200,"操作成功"),
	ERROR(-1,"操作失败"),
	LOGIN_USER_INFO_MISS(100,"用户信息不完整!!!"),
	LOGIN_CODE_ERROR(101,"验证码错误"),
	LOGIN_USER_MISS(102,"用户不存在"),
	LOGIN_PASSWORD_WERROR(103,"密码错误"),
	LOGIN_STATUS_LOCK(104,"该用户已被锁定,请联系管理员进行解锁"),
	BRAND_INFO_NOT(301,"信息不完整"),
	REGISTER_ERROR_EMPTY(201,"注册信息不完整"),
	REGISTER_ERROR_USERNAME_NULL(202,"注册的用户已存在"),
	REGISTER_REDIS_CODE_EMPTY(203,"验证码已失效,请重新获取"),
	REGISTER_CODE_ERROR(204,"验证码错误"),
	SMS_MOBILE_EMPTY(305,"手机号为空"),
	SMS_MOBILE_INVALIDATE(302,"手机号不合法");

	
	
	private int code;
	
	private String msg;
	
	private SystemEnum(int code, String msg) {
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
