package com.shayan.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shayan.user.dao.UserDetailsEntityDao;
import com.shayan.user.entity.UserModel;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	

@Autowired
private UserDetailsEntityDao applicationDao;
	
@Override
public UserModel insertBook(UserModel productEntity ) {
	return applicationDao.save(productEntity);
}

@Override
public List<UserModel> listAllBooks() {
	return applicationDao.findAll();
}

@Override
public Optional<UserModel> findBookById(int bookId) {
	return applicationDao.findById(bookId);
}



}
