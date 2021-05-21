package com.shayan.book.entity;

import com.shayan.book.base.BaseResponse;

import lombok.Data;


@Data
public class AddBookResponse  extends BaseResponse {

	
	private BookModel bookModel;

	public BookModel getBookModel() {
		return bookModel;
	}

	public void setBookModel(BookModel bookModel) {
		this.bookModel = bookModel;
	}
	
	
}
