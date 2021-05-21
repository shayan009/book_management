package com.shayan.book.entity;

import java.io.Serializable;
import java.util.List;

import com.shayan.book.base.BaseResponse;

import lombok.Data;



public class BookListResponse  extends BaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<BookModel> bookModel;

	private int count=0;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<BookModel> getBookModel() {
		return bookModel;
	}

	public void setBookModel(List<BookModel> bookModel) {
		this.bookModel = bookModel;
	}

	
	
}
