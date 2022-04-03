package com.shopstyle.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"com.shopstyle.repository"}) // @Enable : bật tính năng
@EnableTransactionManagement
public class JPAConfig {
	
	//Load Container Entity Manager Factory ( Gọi tắt là nhà máy ) 
	//==> Sau khi có nhà máy mới tạo được Entity Manager và mới thực thi đc mấy câu SQL Xàm xí 
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource()); // ( Cụ thể là chổ này )
		em.setPersistenceUnitName("persistence-data"); // Được cấu hình trong ./META-INF/persistence.xml cầu nối để mapping giữ entity và database
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		return em;
	}
	
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	} 
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	// Cung cấp drive user pass url cho Container Entity Manager Factory ở trên
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/shop1");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		return dataSource;
	}
	
	Properties additionalProperties() {
		Properties properties = new Properties();
//		properties.setProperty("hibernate.hbm2ddl.auto", "create");
//		properties.setProperty("hibernate.hbm2ddl.auto", "update");
//		properties.setProperty("hibernate.hbm2ddl.auto", "create-drop"); // Giúp tạo database từ java class (ENTITY).
		properties.setProperty("hibernate.hbm2ddl.auto", "none"); // Sử dụng sau khi có database ổn định và chỉnh sửa ít ( thủ công )
		properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
		return properties;
	}
}
