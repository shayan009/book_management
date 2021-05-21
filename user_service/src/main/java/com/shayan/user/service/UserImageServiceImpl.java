package com.shayan.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shayan.user.dao.UserImagesEntityDao;
import com.shayan.user.entity.UserImagesModel;

@Service
public class UserImageServiceImpl implements UserImageService{

	
	@Autowired
	UserImagesEntityDao userImagesEntityDao;
	
	@Override
	public UserImagesModel insertUserImage(UserImagesModel userImagesModel) {
		return userImagesEntityDao.save(userImagesModel);

	}

	@Override
	public List<UserImagesModel> listAllBooksImages() {
		return userImagesEntityDao.findAll();
	}

	@Override
	public Optional<UserImagesModel> findBookImageById(int bookImageId) {
		return userImagesEntityDao.findById(bookImageId);
	}

	@Override
	public void deleteBookImage(int bookImageId) {
		userImagesEntityDao.deleteById(bookImageId);
	}

	

}
