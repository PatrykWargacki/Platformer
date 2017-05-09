package main.java.application.config;

import java.util.HashMap;
import java.util.Map;

public class PrimitiveToWrapper {
	private final static Map<Class<?>, Class<?>> map = new HashMap<Class<?>, Class<?>>();
	static{
		map.put(boolean.class, 	Boolean.class);
	    map.put(byte.class, 	Byte.class);
	    map.put(short.class, 	Short.class);
	    map.put(char.class, 	Character.class);
	    map.put(int.class, 		Integer.class);
	    map.put(long.class, 	Long.class);
	    map.put(float.class, 	Float.class);
	    map.put(double.class, 	Double.class);
	}
	
	public static Class<?> get(Class<?> clas){
		return map.get(clas);
	}
}