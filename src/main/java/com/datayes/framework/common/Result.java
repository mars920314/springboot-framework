package com.datayes.framework.common;

public class Result {
	private Integer code;
	private String message;
	Object data;
	
	public Result() {
		code = ResultCode.SUCCESS.getCode();
		message = ResultCode.SUCCESS.getMessage();
	}

	public Result(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public Result(Integer code, String message, Object... args) {
		this.code = code;
		this.message = String.format(message, args);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
