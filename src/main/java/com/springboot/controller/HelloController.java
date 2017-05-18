package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.dao.GirlProperties;


//配合返回json
@Controller
public class HelloController {

	@Value("${url}")
	private String url;//货取配置文件中的url
	@Autowired
	private GirlProperties girl;
	@RequestMapping(value={"/hello/{id}","hi"},method=RequestMethod.GET)
	public String  index(@PathVariable("id") int id){
		System.out.println("执行方法controller");
		return "id:"+id;
	}
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public ModelAndView test(){
		ModelAndView view=new ModelAndView("index");
		return view;
	}
	@RequestMapping(value="/")
	public void getPara(){
		System.out.println(girl.getAge());
		System.out.println(url);
	}
}
