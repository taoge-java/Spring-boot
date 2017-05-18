package com.springboot.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.util.CheckUtil;

@RestController
public class WeiXinController {
	
	@GetMapping(value="/weixin")
	public String weixin(String signature,String timestamp,String nonce,String echostr,HttpServletResponse resp){
		//ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		//HttpServletResponse response=attributes.getResponse();
		OutputStream p=null;
		try {
			p=resp.getOutputStream();
			if(CheckUtil.checkSignature(signature, timestamp, nonce)){
				System.out.println(echostr);
				System.out.println("验证成功");
				p.write(2);
			}//hjh
			return "验证成功";
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(p!=null){
				try {
					p.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return "验证失败";
	}
}
