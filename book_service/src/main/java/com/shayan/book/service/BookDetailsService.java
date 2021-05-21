package com.shayan.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.shayan.book.entity.BookModel;

public interface BookDetailsService {

	BookModel insertBook(BookModel bookModel);
	
	List<BookModel> listAllBooks();

	Optional<BookModel> findBookById(int bookId);

}
