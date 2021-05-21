package com.shayan.book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;


@Entity
@Table(name = "book_images")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="imageId")
public class BookImagesModel {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_id")
	private long imageId;

	@ManyToOne
    @JoinColumn(name = "book_id")
	private BookModel book_model;

	
	@Column(name = "image_path")
	private String imagePath;

	public long getImageId() {
		return imageId;
	}

	
	public BookModel getBook() {
		return book_model;
	}


	public void setBook(BookModel book) {
		this.book_model = book;
	}


	public void setImageId(long imageId) {
		this.imageId = imageId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
