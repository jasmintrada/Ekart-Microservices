package com.infy.utils;

public class Response<T> {
	private T message;
	private int code;
	public T getMessage() {
		return message;
	}
	public void setMessage(T message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	
}
