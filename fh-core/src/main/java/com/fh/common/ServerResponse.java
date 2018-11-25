/** 
 * <pre>项目名称:shop-admin2 
 * 文件名称:ServerResponse.java 
 * 包名:com.fh.shop.admin.common 
 * 创建日期:2018年10月18日下午7:06:48 
 * Copyright (c) 2018, 1145159483@qq.com All Rights Reserved.</pre> 
 */  
package com.fh.common;

/** 
 * <pre>项目名称：shop-admin2    
 * 类名称：ServerResponse    
 * 类描述：    
 * 创建人：高兵 1145159483@qq.com    
 * 创建时间：2018年10月18日 下午7:06:48    
 * 修改人：高兵 1145159483@qq.com     
 * 修改时间：2018年10月18日 下午7:06:48    
 * 修改备注：       
 * @version </pre>    
 */
public class ServerResponse<T> {

	private int code;
	
	private String msg;
	
	private T data;

	public ServerResponse(){
		
	}
	
	public ServerResponse(int code,String msg,T data){
		this.code=code;
		this.msg=msg;
		this.data=data;
	}
	
	public static <T> ServerResponse<T> success(T data){
		return new ServerResponse<T>(SystemEnum.OK.getCode(), SystemEnum.OK.getMsg(), data);
	}
	
	public static ServerResponse error(IEnum systemEnum){
		return new ServerResponse(systemEnum.getCode(),systemEnum.getMsg(),null);
	}
	
	public static ServerResponse error(){
		return new ServerResponse(SystemEnum.ERROR.getCode(),SystemEnum.ERROR.getMsg(),null);
	}
	public static ServerResponse error(int code,String msg){
		return new ServerResponse(code,msg,null);
	}
	public static ServerResponse success(){
		return new ServerResponse(SystemEnum.OK.getCode(), SystemEnum.OK.getMsg(), null);
	}
	public int getCode() {
		return code;
	}

	

	public String getMsg() {
		return msg;
	}

	

	public T getData() {
		return data;
	}

	

	/* (non-Javadoc)    
	 * @see java.lang.T#toString()
	 */
	@Override
	public String toString() {
		return "ServerResponse [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
	
	
	
}
