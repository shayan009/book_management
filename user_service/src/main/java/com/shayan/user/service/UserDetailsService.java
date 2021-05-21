package com.shayan.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.shayan.user.entity.UserModel;

public interface UserDetailsService {

	UserModel insertBook(UserModel userModel);
	
	List<UserModel> listAllBooks();

	Optional<UserModel> findBookById(int bookId);

}
