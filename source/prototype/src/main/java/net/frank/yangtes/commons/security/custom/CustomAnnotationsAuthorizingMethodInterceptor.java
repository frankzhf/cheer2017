package net.frank.yangtes.commons.security.custom;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.aop.AnnotationResolver;
import org.apache.shiro.authz.aop.AuthenticatedAnnotationMethodInterceptor;
import org.apache.shiro.authz.aop.AuthorizingAnnotationMethodInterceptor;
import org.apache.shiro.authz.aop.GuestAnnotationMethodInterceptor;
import org.apache.shiro.authz.aop.RoleAnnotationMethodInterceptor;
import org.apache.shiro.authz.aop.UserAnnotationMethodInterceptor;
import org.apache.shiro.spring.aop.SpringAnnotationResolver;
import org.apache.shiro.spring.security.interceptor.AopAllianceAnnotationsAuthorizingMethodInterceptor;

public class CustomAnnotationsAuthorizingMethodInterceptor 
	extends AopAllianceAnnotationsAuthorizingMethodInterceptor {

	public CustomAnnotationsAuthorizingMethodInterceptor() {
		List<AuthorizingAnnotationMethodInterceptor> interceptors = new ArrayList<AuthorizingAnnotationMethodInterceptor>(
				5);
		AnnotationResolver resolver = new SpringAnnotationResolver();
		interceptors.add(new RoleAnnotationMethodInterceptor(resolver));
		interceptors.add(new CustomPermissionAnnotationMethodInterceptor(new CustomPermissionAnnotationHandler()));
		interceptors.add(new AuthenticatedAnnotationMethodInterceptor(resolver));
		interceptors.add(new UserAnnotationMethodInterceptor(resolver));
		interceptors.add(new GuestAnnotationMethodInterceptor(resolver));
		
		setMethodInterceptors(interceptors);

	}
}
