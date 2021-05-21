package com.shayan.user.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shayan.user.entity.AddUserResponse;
import com.shayan.user.entity.UserDetailResponse;
import com.shayan.user.entity.UserImagesModel;
import com.shayan.user.entity.BookListResponse;
import com.shayan.user.entity.UserModel;
import com.shayan.user.entity.UploadBookImageResponse;
import com.shayan.user.service.UserDetailsServiceImpl;
import com.shayan.user.service.UserImageServiceImpl;
import com.shayan.user.service.FileStorageServiceImpl;
import com.shayan.user.utils.BookNotFoundException;




@RestController
public class UserController {


	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;	

	@Autowired
	private UserImageServiceImpl userImageServiceImpl;
	
	@Autowired
    private FileStorageServiceImpl fileStorageService;

	

	
	@PostMapping(value="/rest/addUser",produces = "application/json")
    public ResponseEntity<AddUserResponse> addUser(@RequestBody UserModel userModel){
	UserModel entity=	userDetailsServiceImpl.insertBook(userModel);
	
	AddUserResponse responseData=new AddUserResponse();
	if(entity!=null) {
		responseData.setStatus(true);
		responseData.setMessage("User Inserted");
     	responseData.setBookModel(entity);
	}
	else {
		responseData.setStatus(false);
		responseData.setMessage("User Not Inserted");
	}
	return new ResponseEntity<>(responseData,HttpStatus.CREATED);

    }
	
	


    @PostMapping("/rest/uploadUserImage")
    public ResponseEntity<UploadBookImageResponse> uploadBookImage(@RequestParam("file") MultipartFile file,@RequestParam("book_id") int bookId) {
        String fileName = fileStorageService.storeFile(file);
        
        UploadBookImageResponse responseData=new UploadBookImageResponse();
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/uploads/")
            .path(fileName)
            .build()
            .toUriString();
        
        Optional<UserImagesModel> entity=userImageServiceImpl.findBookImageById(bookId);
        if(entity.isPresent()) {
        	UserImagesModel userImagesModel=entity.get();
			responseData.setStatus(true);
			responseData.setMessage("Book Image Inserted");
			userImagesModel.setImagePath(fileDownloadUri);
	     	responseData.setBookImagesModel(userImageServiceImpl.insertUserImage(userImagesModel));
		}
		else {
			responseData.setStatus(false);
			responseData.setMessage("Book Image Not Inserted");
		}
        return new ResponseEntity<>(responseData,HttpStatus.OK);
		/*
		 * return new Response(fileName, fileDownloadUri, file.getContentType(),
		 * file.getSize());
		 */
    }

	

	  /**
	   * Update product response entity.
	  
	   */
	  @PutMapping("/rest/user/{id}")
	  public ResponseEntity<UserDetailResponse> updateProduct(@PathVariable(value = "id") int bookId, @Valid @RequestBody UserModel userModel) {
	   
		    Optional<UserModel> entity=userDetailsServiceImpl.findBookById(bookId);	  
			UserDetailResponse responseData=new UserDetailResponse();
			if(entity.isPresent()) {
				responseData.setStatus(true);
				responseData.setMessage("Product Found");
		     	responseData.setBookModel(userDetailsServiceImpl.insertBook(userModel));
			}
			else {
				responseData.setStatus(false);
				responseData.setMessage("Product Not Found");
			}
		  
			return new ResponseEntity<>(responseData,HttpStatus.CREATED);
	  }
	
	  
	  /**
	   * Get single product.
	  
	   */
	  @GetMapping("/rest/users/{id}")
	  public ResponseEntity<UserDetailResponse> getProduct(@PathVariable(value = "id") int bookId) {
	   
		  Optional<UserModel> entity=userDetailsServiceImpl.findBookById(bookId);
  
		  UserDetailResponse responseData=new UserDetailResponse();
		  
		  if(!entity.isPresent()) 
			  throw new BookNotFoundException("Product Not Found");
		
			    responseData.setStatus(true);
				responseData.setMessage("Product Found");
				responseData.setBookModel(entity.get());
			  return new ResponseEntity<>(responseData,HttpStatus.OK);
			
	  }
	  
	
	@GetMapping("/rest/users")
	public @ResponseBody BookListResponse books() {
	
		
		BookListResponse responseData=new BookListResponse();
		List<UserModel> productEntities=userDetailsServiceImpl.listAllBooks();
		System.out.println(productEntities);
	
		if(productEntities.size()>0) {
		
			responseData.setStatus(true);
			responseData.setCount(productEntities.size());
	     	responseData.setBookModel(productEntities);
		}
		else {
		
			responseData.setStatus(false);
			responseData.setMessage("Books empty");
		}
		return responseData;
		
	}
}
