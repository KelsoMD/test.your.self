package by.nesterenok.testyourself.spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("by.nesterenok.testyourself.service.impl")
public class ServiceConfig {
}
