package com.shayan.user.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shayan.user.entity.AddUserResponse;
import com.shayan.user.entity.UserImagesModel;
import com.shayan.user.entity.UserModel;
import com.shayan.user.service.UserDetailsServiceImpl;
import com.shayan.user.service.UserImageServiceImpl;
import com.shayan.user.service.FileStorageServiceImpl;

@Controller
public class MainController {

	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;	

	@Autowired
	private UserImageServiceImpl userImageServiceImpl;
	
	@Autowired
    private FileStorageServiceImpl fileStorageService;
	
	
	@GetMapping("/register")
    public String register() {
        return "register";
    }
	
	@GetMapping("/index")
    public String index() {
        return "index";
    }
	
	@PostMapping(value = "/addUser")
	public  ModelAndView addProducts(@RequestParam("user_image") MultipartFile uploadingFiles,@RequestParam Map<String,String> param) {
       System.out.println("addProducts");
		ModelAndView modelAndView = new ModelAndView("result");
		UserModel userModel=new UserModel();
		userModel.setUserName(param.get("user_name"));
		userModel.setUserAge(Integer.valueOf(param.get("user_age")));
		userModel = userDetailsServiceImpl.insertBook(userModel);
		if (userModel != null) {
			String fileName = fileStorageService.storeFile(uploadingFiles);

			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/uploads/")
					.path(fileName).build().toUriString();
			UserImagesModel userImagesModel=new UserImagesModel();
			userImagesModel.setImagePath(fileDownloadUri);
			userImagesModel.setUserModel(userModel);
			userImagesModel = userImageServiceImpl.insertUserImage(userImagesModel);
			if (userImagesModel != null) {
				modelAndView.addObject("message", "Product Added");
			}else {
				modelAndView.addObject("message", "Product Not Added");
			}
			
		} else {
			modelAndView.addObject("message", "Product Not Added");
		}
		/*
		 * for(MultipartFile uploadedFile : uploadingFiles) { String fileName =
		 * fileStorageService.storeFile(file); }
		 */
		
	  return modelAndView;
	} 
	
}
