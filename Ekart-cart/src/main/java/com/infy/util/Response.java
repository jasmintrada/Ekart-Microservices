package com.infy.util;

public class Response<T> {
	T message;
	int data;
	public T getMessage() {
		return message;
	}
	public void setMessage(T message) {
		this.message = message;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
}
