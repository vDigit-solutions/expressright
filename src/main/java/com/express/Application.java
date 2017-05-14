package com.express;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer {

	@Autowired
	ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

	private static Class<Application> applicationClass = Application.class;

	/*
	 * @Bean(autowire=Autowire.BY_NAME)
	 * 
	 * @ConfigurationProperties(prefix="datasource.dcrms") public DataSource
	 * dcrmsDataSource() { return DataSourceBuilder.create().build(); }
	 */

	@Primary
	@Bean(autowire = Autowire.BY_NAME)
	@ConfigurationProperties(prefix = "datasource.express")
	public DataSource expressDataSource() {

		return DataSourceBuilder.create().build();
	}

	/*
	 * @Bean(autowire=Autowire.BY_NAME) public JdbcTemplate dcrmJdbcTemplate(){
	 * return new JdbcTemplate(dcrmsDataSource()); }
	 */

	@Bean(autowire = Autowire.BY_NAME)
	public JdbcTemplate jdbcTemplate() {
		System.out.println("SEE   : " + applicationContext.getBeansOfType(DataSource.class).size());
		return new JdbcTemplate(expressDataSource());
	}

	@Bean(name = "sessionFactory", autowire = Autowire.BY_NAME)
	// @ConditionalOnMissingBean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = null;

		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(expressDataSource());
		bean.setPackagesToScan("com.express.entity");

		Properties props = new Properties();
		props.put("hibernate.dialect", "org.hibernate.dialect.SQLServer2012Dialect");

		bean.setHibernateProperties(props);

		sessionFactory = bean;

		return sessionFactory;
	}

	@Bean
	public FFmpeg ffmpeg() throws IOException {
		return new FFmpeg();
	}

	@Bean
	public FFprobe ffprobe() throws IOException {
		return new FFprobe();
	}

	@Bean
	public FFmpegExecutor ffmpegExecutor() throws IOException {
		return new FFmpegExecutor(ffmpeg(), ffprobe());
	}

	@Autowired
	@Bean
	public HibernateTemplate hibernateTemplte(SessionFactory sessionFactory) {
		return new HibernateTemplate(sessionFactory);
	}

}
