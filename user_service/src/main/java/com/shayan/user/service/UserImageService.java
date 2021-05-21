package com.shayan.user.service;

import java.util.List;
import java.util.Optional;

import com.shayan.user.entity.UserImagesModel;

public interface UserImageService {

	
	UserImagesModel insertUserImage(UserImagesModel userImagesModel);
	
	List<UserImagesModel> listAllBooksImages();

	Optional<UserImagesModel> findBookImageById(int bookImageId);

	 void  deleteBookImage(int bookImageId);
	
}
