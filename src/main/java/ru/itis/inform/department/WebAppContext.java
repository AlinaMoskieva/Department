package ru.itis.inform.department;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.WebSphereDataSourceAdapter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;
import java.net.URISyntaxException;

@Configuration
@EnableWebMvc
@ComponentScan("ru.inis.inform")
public class WebAppContext extends WebMvcConfigurerAdapter {
    @Bean
    public DataSource dataSource() throws URISyntaxException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        String userName = "postgres";
        String password ="moskieva";
        String dbUrlL = "jdbc:postgresql://localhost:5432/department";

        dataSource.setUrl(dbUrlL);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        return dataSource;

    }
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
