package main.java.application.config;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ConfigIO {
	
	/*
	 * Reading from property file associated with instance class name,
	 * values of primitive and String fields.
	 * Values are setted by set methods of instance.
	 */
	public static <T> void load(T instance, String filename){
		Properties prop = new Properties();
		try{
			InputStream in = ConfigIO.class.getResourceAsStream("properties/"
																+ filename
																+ ".properties");
			
			prop.load(in);
			in.close();
		}catch(IOException |
			   NullPointerException e){
			return;
		}
		
		try {
			String name;
			
			for(Object o : prop.keySet()){
				name = o.toString();
				
				for(Method m : instance.getClass()
									   .getMethods()){
					if(m.getName()
						.startsWith("set"
									+ name)){
						
						if(m.getParameterTypes()[0].equals(String.class)){
							m.invoke(instance, prop.getProperty(name));
						}else{
							m.invoke(instance,
									 PrimitiveToWrapper.get(m.getParameterTypes()[0])
									 				   .getMethod("valueOf", String.class)
									 				   .invoke(instance, prop.getProperty(name)));
						}
						break;
					}
				}
			}
		} catch (IllegalArgumentException | 
				 IllegalAccessException | 
				 SecurityException | 
				 InvocationTargetException | 
				 NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	
	public static <T> void load(T instance){
		load(instance, instance.getClass()
							   .getSimpleName());
	}
	
	/*
	 * Writing to property file associated with instance class name,
	 * values of primitive and String fields.
	 * Values are accessible by get or is methods of instance
	 */
	public static <T> void save(T instance, String filename){
		try {
			Properties prop = new Properties();
			Class<?> type;
			Object value;
			int index;
			
			for(Method m : instance.getClass()
					   			   .getMethods()){
				index = 0;
				
				if(m.getName()
					.startsWith("get")){
					index = 3;
				}else if(m.getName()
						  .startsWith("is")){
					index = 2;
				}else{
					continue;
				}
				
				type = m.getReturnType();
				if(index > 0
				   && (type.isPrimitive() 
				   ||  type.equals(String.class))){
					value =  m.invoke(instance);
					if(value != null){
						prop.put(m.getName()
								  .substring(index),
								 m.invoke(instance)
								  .toString());
					}
				}
			}
			
			OutputStream out = new FileOutputStream(ConfigIO.class.getResource("properties/"
																			   + filename
																			   + ".properties")
																  .getPath());
			prop.store(out, null);
			out.close();
		} catch (IOException | 
				 IllegalArgumentException | 
				 IllegalAccessException | 
				 SecurityException | 
				 InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
	
	public static <T> void save(T instance){
		save(instance, instance.getClass()
							   .getSimpleName());
	}
}
