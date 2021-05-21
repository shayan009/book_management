package com.shayan.book.controller;

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

import com.shayan.book.entity.AddBookResponse;
import com.shayan.book.entity.BookDetailResponse;
import com.shayan.book.entity.BookImagesModel;
import com.shayan.book.entity.BookListResponse;
import com.shayan.book.entity.BookModel;
import com.shayan.book.entity.UploadBookImageResponse;
import com.shayan.book.service.BookDetailsServiceImpl;
import com.shayan.book.service.BookImageServiceImpl;
import com.shayan.book.service.FileStorageServiceImpl;
import com.shayan.book.utils.BookNotFoundException;




@RestController
public class BookController {


	@Autowired
	private BookDetailsServiceImpl bookDetailsServiceImpl;	

	@Autowired
	private BookImageServiceImpl bookImageServiceImpl;
	
	@Autowired
    private FileStorageServiceImpl fileStorageService;

	

	
	@PostMapping(value="/rest/addBooks",produces = "application/json")
    public ResponseEntity<AddBookResponse> createVehicle(@RequestBody BookModel bookModel){
	BookModel entity=	bookDetailsServiceImpl.insertBook(bookModel);
	
	AddBookResponse responseData=new AddBookResponse();
	if(entity!=null) {
		responseData.setStatus(true);
		responseData.setMessage("Product Inserted");
     	responseData.setBookModel(entity);
	}
	else {
		responseData.setStatus(false);
		responseData.setMessage("Product Not Inserted");
	}
	return new ResponseEntity<>(responseData,HttpStatus.CREATED);

    }
	
	


    @PostMapping("/rest/uploadBookImage")
    public ResponseEntity<UploadBookImageResponse> uploadBookImage(@RequestParam("file") MultipartFile file,@RequestParam("book_id") int bookId) {
        String fileName = fileStorageService.storeFile(file);
        
        UploadBookImageResponse responseData=new UploadBookImageResponse();
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/uploads/")
            .path(fileName)
            .build()
            .toUriString();
        
        Optional<BookImagesModel> entity=bookImageServiceImpl.findBookImageById(bookId);
        if(entity.isPresent()) {
        	BookImagesModel bookImagesModel=entity.get();
			responseData.setStatus(true);
			responseData.setMessage("Book Image Inserted");
			bookImagesModel.setImagePath(fileDownloadUri);
	     	responseData.setBookImagesModel(bookImageServiceImpl.insertBookImage(bookImagesModel));
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
	  @PutMapping("/rest/book/{id}")
	  public ResponseEntity<BookDetailResponse> updateProduct(@PathVariable(value = "id") int bookId, @Valid @RequestBody BookModel bookModel) {
	   
		    Optional<BookModel> entity=bookDetailsServiceImpl.findBookById(bookId);	  
			BookDetailResponse responseData=new BookDetailResponse();
			if(entity.isPresent()) {
				responseData.setStatus(true);
				responseData.setMessage("Product Found");
		     	responseData.setBookModel(bookDetailsServiceImpl.insertBook(bookModel));
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
	  @GetMapping("/rest/books/{id}")
	  public ResponseEntity<BookDetailResponse> getProduct(@PathVariable(value = "id") int bookId) {
	   
		  Optional<BookModel> entity=bookDetailsServiceImpl.findBookById(bookId);
  
		  BookDetailResponse responseData=new BookDetailResponse();
		  
		  if(!entity.isPresent()) 
			  throw new BookNotFoundException("Product Not Found");
		
			    responseData.setStatus(true);
				responseData.setMessage("Product Found");
				responseData.setBookModel(entity.get());
			  return new ResponseEntity<>(responseData,HttpStatus.OK);
			
	  }
	  
	
	@GetMapping("/rest/books")
	public @ResponseBody BookListResponse books() {
	
		
		BookListResponse responseData=new BookListResponse();
		List<BookModel> productEntities=bookDetailsServiceImpl.listAllBooks();
		System.out.println(productEntities.toString());
	
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
