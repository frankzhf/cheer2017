package net.frank.yangtes.commons.cover.interceptor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
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

@Intercepts(@Signature(type = ResultSetHandler .class,
	method = "handleResultSets", args = { Statement.class }))
public class ResultCoverFilter implements Interceptor {
	
	private transient Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		if (CoverFilterHolder.getCoverFilter()) {
			Statement stmt = (Statement)invocation.getArgs()[0];
			if(stmt.getResultSet().getMetaData().getColumnCount() > 1){
				Object result = invocation.proceed();
				if(result instanceof List<?>){
					List<?> _result = (List<?>) result;
					if(!_result.isEmpty()){
						for(int i=0;i<_result.size();i++){
							Object item = _result.get(i);
							processCoverItem(item);
						}
					}
				}else if(result instanceof Object){
					processCoverItem(result);
				}
				CoverFilterHolder.reset();
				return result;
			}
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
	
	private void processCoverItem(Object item){
		Class<?> clazz = item.getClass();
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
					Object oldValue = mGet.invoke(item);
					if(oldValue instanceof String){
						String _oldValue = (String)oldValue;
						String value = Helper.decodeDES(
								_oldValue, desKey);
						mSet.invoke(item, value);
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
	
	private static String getFirstUpperString(String value){
		String firstChar =value.substring(0,1);
		return firstChar.toUpperCase().concat(value.substring(1));
	}

}
