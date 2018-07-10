package by.nesterenok.testyourself.spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan({"by.nesterenok.testyourself.dao.database.hbn","by.nesterenok.testyourself.service.impl"})
public class AppConfig {

}
