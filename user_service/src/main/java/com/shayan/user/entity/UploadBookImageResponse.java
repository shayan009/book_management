package com.shayan.user.entity;

import com.shayan.user.base.BaseResponse;

import lombok.Data;


@Data
public class UploadBookImageResponse extends BaseResponse {

		
		private UserImagesModel userImagesModel;

		public UserImagesModel getBookImagesModel() {
			return userImagesModel;
		}

		public void setBookImagesModel(UserImagesModel userImagesModel) {
			this.userImagesModel = userImagesModel;
		}

		
}
