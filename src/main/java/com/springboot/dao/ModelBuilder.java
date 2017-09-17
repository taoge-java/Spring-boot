package com.springboot.dao;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;

import com.springboot.util.StrKit;


public class ModelBuilder {

	private static final ModelBuilder modelBuilder = new ModelBuilder();              
	
	public static ModelBuilder me(){
		return modelBuilder;
	}
	
	private ModelBuilder() {
		
	}
	
	public void fillStatement(PreparedStatement preparedStatement, String sql, Object... paras) throws SQLException{
		for(int i=0;i<paras.length;i++){
			preparedStatement.setObject(i+1,paras[i]);
		}
	}
	
	public <T>  List<T> builderModelList(ResultSet resultSet,Class<T> cla) throws SQLException{
    	List<T> list = new ArrayList<T>();
		try {
			while (resultSet.next()) {
				T t = cla.newInstance();
				Field[] fieldield = cla.getDeclaredFields();
				for (Field field : fieldield) {
					try {
						field.setAccessible(true);
						Column column = field.getAnnotation(Column.class);
						if(StrKit.isNotEmpoty(column) && StrKit.isNotEmpoty(column.name())){
							field.set(t, resultSet.getObject(column.name()));
						}else{
							field.set(t, resultSet.getObject(field.getName()));
						}
					} catch (SQLException e) {
						throw new SQLException(field.getName()+" doesn't in this table");
					}
				}
				list.add((T)t);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
