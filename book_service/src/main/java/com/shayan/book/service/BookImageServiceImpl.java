package com.shayan.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shayan.book.dao.BookImagesEntityDao;
import com.shayan.book.entity.BookImagesModel;

@Service
public class BookImageServiceImpl implements BookImageService{

	
	@Autowired
	BookImagesEntityDao bookImagesEntityDao;
	
	@Override
	public BookImagesModel insertBookImage(BookImagesModel bookImagesModel) {
		return bookImagesEntityDao.save(bookImagesModel);

	}

	@Override
	public List<BookImagesModel> listAllBooksImages() {
		return bookImagesEntityDao.findAll();
	}

	@Override
	public Optional<BookImagesModel> findBookImageById(int bookImageId) {
		return bookImagesEntityDao.findById(bookImageId);
	}

	@Override
	public void deleteBookImage(int bookImageId) {
		bookImagesEntityDao.deleteById(bookImageId);
	}

	

}
