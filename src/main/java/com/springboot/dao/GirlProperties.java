package com.springboot.dao;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;
@Repository
@ConfigurationProperties(prefix="girl")
public class GirlProperties {

	private int age;
	
	private String name;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	private int grade;
}
