package com.adobe.prj.cfg;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

// only @Configuration classes can have Factory Method
@Configuration
public class AppConfig {
	
	// DataSource is a pool of database connection
	// @Bean --> FactoryMethod
	@Bean
	public DataSource getDataSource() throws Exception {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass( "com.mysql.cj.jdbc.Driver" ); //loads the jdbc driver            
		cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/NCG_DB" );
		cpds.setUser("root");                                  
		cpds.setPassword("Welcome123");                                  
			
		// the settings below are optional -- c3p0 can work with defaults
		cpds.setMinPoolSize(5);                                     
		cpds.setAcquireIncrement(5);
		cpds.setMaxPoolSize(20);
		return cpds;
	}
}
