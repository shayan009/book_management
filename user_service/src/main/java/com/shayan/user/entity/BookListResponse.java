package com.shayan.user.entity;

import java.io.Serializable;
import java.util.List;

import com.shayan.user.base.BaseResponse;

import lombok.Data;



public class BookListResponse  extends BaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<UserModel> userModel;

	private int count=0;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<UserModel> getBookModel() {
		return userModel;
	}

	public void setBookModel(List<UserModel> userModel) {
		this.userModel = userModel;
	}

	
	
}
