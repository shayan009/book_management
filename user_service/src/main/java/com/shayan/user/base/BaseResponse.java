package com.shayan.user.base;

import java.io.Serializable;
import java.util.List;

import com.shayan.user.entity.UserModel;

public class BaseResponse  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean status;
	String message;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
