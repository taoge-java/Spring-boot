package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.controller.UserRepository;
import com.springboot.dao.User;
@Service
public class UserService {

	@Autowired
	private UserRepository user;
	/**
	 * 事务管理
	 */
	@SuppressWarnings("unused")
	@Transactional
	public void insert(){
		try{
		    User user1=new User();
		    user1.setName("java");
		    user1.setPassword("123456");
		    user.save(user1);
			int i=1/0;
			User user2=new User();
			user2.setName("php");
			user2.setPassword("123456");
			user.save(user1);
		}catch(Exception e){
			System.out.println("失败");
		}
		
	}
}
