package com.springboot.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.springboot.dao.TextMessage;
import com.thoughtworks.xstream.XStream;

public class XmlUtil {

	public static final String MESSAGE_TEXT="text";
	public static final String MESSAGE_IMAGE="image";
	public static final String MESSAGE_VOICE="voice";
	public static final String MESSAGE_VIDEO="video";
	public static final String MESSAGE_EVENT="event";
	public static final String MESSAGE_LINK="link";
	public static final String MESSAGE_CLICK="click";
	public static final String MESSAGE_LOCATION="location";
	public static final String MESSAGE_SUBSCRIBE="subscribe";
	public static final String MESSAGE_UNSUBSCRIBE="unsubscribe";
	public static final String MESSAGE_VIEW="view";
	/**
	 * xml转换成map
	 */
	
	@SuppressWarnings("unchecked")
	public static Map<String,String> xmlToMap(HttpServletRequest request){
		SAXReader xmlRead=new SAXReader();
		InputStream in=null;
		Map<String,String> map=new HashMap<String, String>();
		try {
			in=request.getInputStream();
			Document doc=xmlRead.read(in);
		    Element element=doc.getRootElement();
		    List<Element> list=element.elements();
		    for(Element e:list){
		    	map.put(e.getName(), e.getTextTrim());
		    }
		    return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * message转成xml
	 */
	public static String messageToXml(TextMessage message){
		XStream stream=new XStream();
		stream.alias("xml", message.getClass());
		return stream.toXML(message);
	}
	/**
	 * 获得菜单
	 */
	public static String getMenu(){
		StringBuffer sb=new StringBuffer();
		sb.append("欢迎您的关注,请按照提示进行操作:\n\n");
		sb.append("1.java基础课程");
		sb.append("2.javaWeb基础");
		sb.append("3.javaWeb项目实战");
		return sb.toString();
	}
}
