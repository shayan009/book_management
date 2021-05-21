package com.shayan.book.service;

import java.util.List;
import java.util.Optional;

import com.shayan.book.entity.BookImagesModel;

public interface BookImageService {

	
	BookImagesModel insertBookImage(BookImagesModel bookImagesModel);
	
	List<BookImagesModel> listAllBooksImages();

	Optional<BookImagesModel> findBookImageById(int bookImageId);

	 void  deleteBookImage(int bookImageId);
	
}
