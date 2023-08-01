package com.miguelDev.EventoApp.configuration;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/*Classe de configuração do banco de dados*/

@Configuration
public class DataConfiguration {
    @Bean
	public DataSource dataSource() {
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName("org.postgresql.Driver");
	    source.setUrl("jdbc:postgresql://localhost:5432/eventoApp");
	    source.setUsername("postgres");
	    source.setPassword("123");
	    return source;
	}
    
    @Bean
    public JpaVendorAdapter jpaVendoAdapter() {
      HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
      adapter.setDatabase(Database.POSTGRESQL);
      adapter.setShowSql(true);
      adapter.setGenerateDdl(true);
      adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
      adapter.setPrepareConnection(true);
      return adapter;
    } 
}
