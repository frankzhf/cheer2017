package net.frank.yangtes.commons.security.custom;


import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;


public class CustomAuthorizationAttributeSourceAdvisor extends AuthorizationAttributeSourceAdvisor {

	/**
	* 
	*/
	private static final long serialVersionUID = -2925790074927753232L;

	public CustomAuthorizationAttributeSourceAdvisor() {
		setAdvice(new CustomAnnotationsAuthorizingMethodInterceptor());
	}
	
	/***
	 * 
	 * spring configuration as below
	 * 
	 * 
	<bean class="net.frank.yangtes.commons.security.custom.CustomAuthorizationAttributeSourceAdvisor">
    	<property name="securityManager" ref="securityManager"/>
	</bean>
	 * 
	 * 
	 */
	
}
