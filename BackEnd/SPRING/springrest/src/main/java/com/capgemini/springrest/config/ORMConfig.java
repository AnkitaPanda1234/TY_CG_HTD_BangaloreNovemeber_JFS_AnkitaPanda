package com.capgemini.springrest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class ORMConfig {
	@Bean
	public LocalEntityManagerFactoryBean getLocalEntityManagerFactoryBean()
	{
		LocalEntityManagerFactoryBean bean=
				new LocalEntityManagerFactoryBean();  //meat point of hibernate and spring
		bean.setPersistenceUnitName("employee-unit");
		return bean;
	}

}
