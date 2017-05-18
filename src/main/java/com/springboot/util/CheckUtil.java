package com.springboot.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.apache.commons.codec.binary.Hex;


public class CheckUtil {

	public static final String token="hello";
	public static boolean checkSignature(String signature,String timestamp,String nonce){
		String str[]={token,timestamp,nonce};
		Arrays.sort(str);
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<str.length;i++){
			sb.append(str[i]);
		}
		String temp=getSha(sb.toString());
		System.out.println(temp);
		return temp.equals(signature);
	}
	
	public static String getSha(String key){
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("SHA");
			byte[] by=md5.digest(key.getBytes());
			System.err.println(Hex.encodeHexString(by));
			return Hex.encodeHexString(by);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
