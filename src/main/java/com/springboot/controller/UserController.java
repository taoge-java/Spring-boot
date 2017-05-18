package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dao.User;
import com.springboot.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;
	/**
	 * 获取用户列表
	 * @return
	 */
	@GetMapping(value="/users")
	public List<User> getUserList(){
		return userRepository.findAll();
	}
	/**
	 * 添加用户
	 * @param name
	 * @param password
	 * @return
	 */
	@GetMapping(value="/addusers")
	public User addUser(@RequestParam(value="name",defaultValue="java") String name,@RequestParam("password") String password){
		System.out.println(1);
		User user=new User();
		user.setName(name);
		user.setPassword(password);
		return userRepository.save(user);
	}
	/**
	 * 查找用户
	 * @param id
	 * @return
	 */
	@GetMapping(value="/find/{id}")
	public  User findById(@PathVariable("id") int id){
		return userRepository.findOne(id);
	}
	
	/**
	 * 删除用户
	 */
	@GetMapping(value="/del/{id}")
	public  void delById(@PathVariable("id") int id){
		 userRepository.delete(id);
	}
	
	/**
	 * 修改用户
	 */
	@GetMapping(value="/update/{id}")
	public  User updateById(@PathVariable("id") int id,@RequestParam("name")String name,@RequestParam("password") String password){
		User user=new User();
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		return userRepository.save(user);
	}
	
	/**
	 * 
	 */
	@GetMapping(value="/update1")
	public  List<User> find(@RequestParam("name")String name){
		return userRepository.findByName(name);
	}
	
	
	@GetMapping(value="/add1")
	public  void add(){
		userService.insert();
	}
}
