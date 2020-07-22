package cuckoo.web;	
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration {
	@Value("${db.driver}")
	private String DRIVER;

	@Value("${db.password}")
	private String PASSWORD;

	@Value("${db.url}")
	private String URL;

	@Value("${db.username}")
	private String USERNAME;

	@Value("${hibernate.dialect}")
	private String DIALECT;

	@Value("${hibernate.show_sql}")
	private String SHOW_SQL;

	@Value("${hibernate.hbm2ddl.auto}")
	private String HBM2DDL_AUTO;

	@Value("${entitymanager.packagesToScan}")
	private String PACKAGES_TO_SCAN;
	
	@Value("${hibernate.enable_lazy_load_no_trans}")
	private String enableLazyLoadNoTrans;
	
	@Value("${max.conn.pool.size}")
	private int maxConnectionPoolSize;

	@Bean
	public DataSource dataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName(DRIVER);
//		dataSource.setUrl(URL);
//		dataSource.setUsername(USERNAME);
//		dataSource.setPassword(PASSWORD);
//		return dataSource;
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName(DRIVER);
		hikariConfig.setJdbcUrl(URL);
		hikariConfig.setUsername(USERNAME);
		hikariConfig.setPassword(PASSWORD);
		hikariConfig.setConnectionTestQuery("SELECT 1");
		hikariConfig.setMaximumPoolSize(maxConnectionPoolSize);
		hikariConfig.setConnectionInitSql("set application_name to WebApp; ");
		return new HikariDataSource(hikariConfig);
	}

	@Bean 
	public JpaTransactionManager jpaTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		return transactionManager;
	}
	
	@Bean
	public HibernateJpaVendorAdapter vendorAdaptor() {
		HibernateJpaVendorAdapter venodrAdapter = new HibernateJpaVendorAdapter();
		venodrAdapter.setShowSql(true);
		return venodrAdapter;
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdaptor());
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setPackagesToScan(PACKAGES_TO_SCAN);
		entityManagerFactoryBean.setJpaProperties(jpaHibernateProperties());
		return entityManagerFactoryBean;
	}
	
	
	public Properties jpaHibernateProperties() {
		
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", DIALECT);
		hibernateProperties.put("hibernate.show_sql", SHOW_SQL);
		hibernateProperties.put("hibernate.hbm2ddl.auto", HBM2DDL_AUTO);
		hibernateProperties.put("hibernate.enable_lazy_load_no_trans", enableLazyLoadNoTrans);

		return hibernateProperties;
	}

}