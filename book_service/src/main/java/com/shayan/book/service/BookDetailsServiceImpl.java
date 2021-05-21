package com.shayan.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shayan.book.dao.BookDetailsEntityDao;
import com.shayan.book.entity.BookModel;

@Service
public class BookDetailsServiceImpl implements BookDetailsService {

	

@Autowired
private BookDetailsEntityDao applicationDao;
	
@Override
public BookModel insertBook(BookModel productEntity ) {
	return applicationDao.save(productEntity);
}

@Override
public List<BookModel> listAllBooks() {
	return applicationDao.findAll();
}

@Override
public Optional<BookModel> findBookById(int bookId) {
	return applicationDao.findById(bookId);
}



}
