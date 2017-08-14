package net.frank.yangtes.commons.cover.interceptor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.frank.yangtes.commons.cover.CoverFilterHolder;
import net.frank.yangtes.commons.cover.Helper;
import net.frank.yangtes.commons.cover.annotation.CoverField;

@Intercepts(@Signature(type = Executor.class,
	method = "update", args = { MappedStatement.class, Object.class }))
public class PreCoverFilter implements Interceptor {

	private transient Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		if (CoverFilterHolder.getCoverFilter()) {
			MappedStatement ms = (MappedStatement) invocation.getArgs()[0];
			Object param = (Object) invocation.getArgs()[1];
			log.debug("Varrible [ms] -> " + ms);
			log.debug("Varrible [param] -> " + param);
			Class<?> clazz = param.getClass();
			Field[] fields = clazz.getDeclaredFields();
			for (Field f : fields) {
				if (f.isAnnotationPresent(CoverField.class)) {
					String desKey = f.getAnnotation(CoverField.class)
						.desKey();
					String fieldName = f.getName();
					String getMethod = "get" + getFirstUpperString(fieldName);
					String setMethod = "set" + getFirstUpperString(fieldName);
					try{
						Method mGet = clazz.getMethod(getMethod);
						Method mSet = clazz.getMethod(setMethod,mGet.getReturnType());
						
						Object oldValue = mGet.invoke(param);
						if(oldValue instanceof String){
							String _oldValue = (String)oldValue;
							String value = Helper.encodeDes(
									_oldValue, desKey);
							mSet.invoke(param, value);
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
			CoverFilterHolder.reset();
		}
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {

	}
	
	private static String getFirstUpperString(String value){
		String firstChar =value.substring(0,1);
		return firstChar.toUpperCase().concat(value.substring(1));
	}

}
