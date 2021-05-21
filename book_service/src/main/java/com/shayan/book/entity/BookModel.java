package com.shayan.book.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;




@Entity
@Table(name = "book")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="bookId")
public class BookModel{

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
	private int bookId;
	
	
	@Column(name="book_name")
    private String bookName;
	
	@Column(name="book_author")
    private String bookAuthor;
	
	@Column(name="book_publish_date")
    private Date bookPublishDate;
	
	@Column(name="book_price")
    private double bookPrice;
	
        @OneToMany(mappedBy = "book_model")
	    List<BookImagesModel>  bookImagesModels;
	
	

    
    public BookModel() {
    }




	public long getBookId() {
		return bookId;
	}




	/*
	 * public List<BookImagesModel> getBookImagesModels() { return bookImagesModels;
	 * }
	 */



	public List<BookImagesModel> getBookImagesModels() {
		return bookImagesModels;
	}




	public void setBookImagesModels(List<BookImagesModel> bookImagesModels) {
		this.bookImagesModels = bookImagesModels;
	}




	public void setBookId(int bookId) {
		this.bookId = bookId;
	}




	public void setBookName(String bookName) {
		this.bookName = bookName;
	}




	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}




	public void setBookPublishDate(Date bookPublishDate) {
		this.bookPublishDate = bookPublishDate;
	}




	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}



	/*
	 * public void setBookImagesModels(List<BookImagesModel> bookImagesModels) {
	 * this.bookImagesModels = bookImagesModels; }
	 */



	public String getBookName() {
		return bookName;
	}


	public String getBookAuthor() {
		return bookAuthor;
	}


	public Date getBookPublishDate() {
		return bookPublishDate;
	}


	public double getBookPrice() {
		return bookPrice;
	}



  

}
