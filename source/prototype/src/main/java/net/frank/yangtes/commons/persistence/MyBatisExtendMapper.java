package net.frank.yangtes.commons.persistence;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.TypedStringValue;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

public class MyBatisExtendMapper implements BeanDefinitionRegistryPostProcessor {

	private static final String DEFAULT_FIELD_NAME = "basePackage";

	private static final String DEFAULT_SPLITE = ";";

	private String beanId;

	private String extendsBasePackage;

	public void setBeanId(String beanId) {
		this.beanId = beanId;
	}

	public void setExtendsBasePackage(String extendsBasePackage) {
		this.extendsBasePackage = extendsBasePackage;
	}

	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		
	}
	@Override
	public void postProcessBeanDefinitionRegistry(
			BeanDefinitionRegistry registry) throws BeansException {
		if (StringUtils.isNoneBlank(beanId)) {
			BeanDefinition bd = registry.getBeanDefinition(beanId);
			if (bd != null && StringUtils.isNoneBlank(extendsBasePackage)) {
				MutablePropertyValues pv = bd.getPropertyValues();
				if (pv.contains(DEFAULT_FIELD_NAME)) {
					Object p = pv.get(DEFAULT_FIELD_NAME);
					if (p instanceof TypedStringValue) {
						TypedStringValue property = (TypedStringValue) p;
						String oldValue = property.getValue();
						pv.addPropertyValue(DEFAULT_FIELD_NAME, oldValue
								+ DEFAULT_SPLITE + extendsBasePackage);
					}
				}
			}
		}	
	}
}
