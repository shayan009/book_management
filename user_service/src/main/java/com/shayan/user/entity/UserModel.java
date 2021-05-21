package com.shayan.user.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;




@Entity
@Table(name = "user")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="userId")
public class UserModel{

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
	private int userId;
	

	@Column(name="user_name")
    private String userName;
	
	@Column(name="user_email")
    private String userEmail;
	
	@Column(name="user_mobile")
    private double userMobile;
	
	@Column(name="user_age")
    private int userAge;
	
        @OneToMany(mappedBy = "user_model")
	    List<UserImagesModel>  userImagesModels;
	
	

    
    public UserModel() {
    }




	public int getUserId() {
		return userId;
	}




	public void setUserId(int userId) {
		this.userId = userId;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getUserEmail() {
		return userEmail;
	}




	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}




	public double getUserMobile() {
		return userMobile;
	}




	public void setUserMobile(double userMobile) {
		this.userMobile = userMobile;
	}




	public int getUserAge() {
		return userAge;
	}




	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}




	public List<UserImagesModel> getUserImagesModels() {
		return userImagesModels;
	}




	public void setUserImagesModels(List<UserImagesModel> userImagesModels) {
		this.userImagesModels = userImagesModels;
	}





  

}
