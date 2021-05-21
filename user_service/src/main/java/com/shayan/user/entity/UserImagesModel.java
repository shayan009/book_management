package com.shayan.user.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@Entity
@Table(name = "user_images")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="imageId")
public class UserImagesModel {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_id")
	private long imageId;

	@ManyToOne
    @JoinColumn(name = "user_id")
	private UserModel user_model;

	
	@Column(name = "image_path")
	private String imagePath;

	public long getImageId() {
		return imageId;
	}

	


	public UserModel getUserModel() {
		return user_model;
	}




	public void setUserModel(UserModel userModel) {
		this.user_model = userModel;
	}




	public void setImageId(long imageId) {
		this.imageId = imageId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
