package net.frank.commons.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public final class ObjectUtil {
	
	private static transient Log log = LogFactory.getLog(ObjectUtil.class);
	
	private static final String TYPE_INT = "int";
	private static final String TYPE_BYTE = "byte";
	private static final String TYPE_LONG = "long";
	private static final String TYPE_SHORT = "short";
	private static final String TYPE_CHAR = "char";
	private static final String TYPE_DOUBLE = "double";
	private static final String TYPE_FLOAT = "float";
	private static final String TYPE_BOOLEAN = "boolean";
	
	private static final String[] skipFieldArray = new String[]{
		"serialVersionUID"
	};
	
	
	public static boolean isBaseType(String className) {
		return TYPE_INT.equals(className) ||
		TYPE_BYTE.equals(className) ||
		TYPE_LONG.equals(className) ||
		TYPE_SHORT.equals(className) ||
		TYPE_CHAR.equals(className) ||
		TYPE_DOUBLE.equals(className) ||
		TYPE_FLOAT.equals(className) ||
		TYPE_BOOLEAN.equals(className);
	}
	
	public static boolean isExtend(Object child,Object target){
		Class<?> currentSuper = child.getClass().getSuperclass();
		do{
			if(currentSuper.equals(target.getClass())){
				return true;
			}
			currentSuper = currentSuper.getSuperclass();
		}while(!currentSuper.equals(java.lang.Object.class));		
		return false;
	}
	
	public static void preparePreperties(Object child,Object parent){
		if(child!=null && parent!=null
				&& isExtend(child,parent)){
			Class<?> _parent = parent.getClass();
			do{				
				Field[] fields = _parent.getDeclaredFields();
				if(fields!=null && fields.length >0){
					for(int i=0;i<fields.length;i++){
						Field field = fields[i];
						String fieldName = field.getName();
						if(isPrepare(fieldName)){
							String getMethod = "get" + getFirstUpperString(fieldName);
							String setMethod = "set" + getFirstUpperString(fieldName);
							try{
								Method mGet = parent.getClass().getMethod(getMethod);
								Method mSet = null;
								if(mGet!=null 
										&&(mSet=parent.getClass().getMethod(setMethod,
												parent.getClass().getMethod(getMethod).getReturnType()))!=null){
									Object rtObject = mGet.invoke(parent, new Object[]{});
									if(rtObject!=null){
										mSet.invoke(child,new Object[]{rtObject});
									}
								}
							}catch(NoSuchMethodException e){
								log.error("skip feild :" + fieldName);
							}catch(IllegalArgumentException e){
								log.error("skip feild :" + fieldName);
							}catch(IllegalAccessException e){
								log.error("skip feild :" + fieldName);
							}catch(InvocationTargetException e){
								log.error("skip feild :" + fieldName);
							}
						}
					}
				}
				_parent = _parent.getSuperclass();
			}while(_parent!=null && !_parent.equals(Object.class));
		}
	}
	
	private static boolean isPrepare(String fieldName){
		boolean rt = true;
		for(int i=0;i<skipFieldArray.length;i++){
			if(skipFieldArray[i].equals(fieldName)){
				rt = false;
				break;
			}
		}
		return rt;
	}
	
	private static String getFirstUpperString(String value){
		String firstChar =value.substring(0,1);
		return firstChar.toUpperCase().concat(value.substring(1));
	}
	
}