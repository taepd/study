package com.model;
/*
DB에
create table photo{
	name 
	age
	image >> 업로드한 파일명 >> 1.jpg , 2.png 
}
*/

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class Photo {
	private String name;
	private int age;
	private String image; //실제 파일이름(CommonsMultipartFile 추출 setter  주입)
	
	//POINT
	private CommonsMultipartFile file;  //업로드한 파일을 담는 변수
	//사진:<input type="file" name="file">

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public CommonsMultipartFile getFile() {
		return file;
	}

	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}
	
	
	
}













