package com.shayan.user.entity;

import com.shayan.user.base.BaseResponse;

import lombok.Data;


@Data
public class UserDetailResponse  extends BaseResponse {

	
	private UserModel userModel;

	public UserModel getBookModel() {
		return userModel;
	}

	public void setBookModel(UserModel userModel) {
		this.userModel = userModel;
	}
	
	
}
