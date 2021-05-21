package com.shayan.book.entity;

import com.shayan.book.base.BaseResponse;

import lombok.Data;


@Data
public class UploadBookImageResponse extends BaseResponse {

		
		private BookImagesModel bookImagesModel;

		public BookImagesModel getBookImagesModel() {
			return bookImagesModel;
		}

		public void setBookImagesModel(BookImagesModel bookImagesModel) {
			this.bookImagesModel = bookImagesModel;
		}

		
}
