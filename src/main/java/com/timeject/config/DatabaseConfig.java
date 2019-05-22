package com.timeject.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource({ "classpath:application.properties" })
public class DatabaseConfig {

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	@ConfigurationProperties("spring.datasource")
	public DataSource dataSource(DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().build();
	}
}