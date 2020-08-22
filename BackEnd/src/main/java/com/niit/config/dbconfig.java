package com.niit.config;
import java.util.Properties;

import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.UserDetail;
import com.niit.model.CartItem;
import com.niit.model.OrderDetail;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.niit")
public class dbconfig 
{   @Bean(name="datasource")
public DataSource getOracleDataSource()

{
	
DriverManagerDataSource datasource = new DriverManagerDataSource();
	
	datasource.setDriverClassName("org.h2.Driver");
	datasource.setUrl("jdbc:h2:tcp://localhost/~/test");
	datasource.setUsername("sa");
	datasource.setPassword("sa");
	System.out.println("Creating Datasource bean");
	return datasource;
}

  @Bean(name="sessionfactory")
  public SessionFactory getSessionFactory()
  {  
	  Properties property=new Properties();
	 property.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
	  property.setProperty("hibernate.hbm2ddl.auto","update");
	  property.setProperty("hibernate.show_sql","true");
	  
	  LocalSessionFactoryBuilder lsfb=new LocalSessionFactoryBuilder(getOracleDataSource());
	  lsfb.addProperties(property);
	  lsfb.addAnnotatedClass(Category.class);
	  lsfb.addAnnotatedClass(Product.class);
	  lsfb.addAnnotatedClass(Supplier.class);
	  lsfb.addAnnotatedClass(UserDetail.class);
	  lsfb.addAnnotatedClass(OrderDetail.class);	  
	  lsfb.addAnnotatedClass(CartItem.class);
	  
	  SessionFactory sessionfactory=lsfb.buildSessionFactory();
	  return sessionfactory;  	  	  
	  
  }
  
  
  @Bean(name="txManager")
  public HibernateTransactionManager getHibernateTranscationManager(SessionFactory sessionfactory)
  { 	
	  return new HibernateTransactionManager(sessionfactory);
  }
  
 
  
}


