package by.nesterenok.testyourself.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.Properties;

@EnableWebMvc
@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"by.nesterenok.testyourself.web.action.implmvc", "by.nesterenok.testyourself.web.aspect"})
public class SpringMvcConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**","mentor/assets/**",
				"mentor/groups/assets/**", "user/groups/assets/**",
				"user/assets/**",
				"user/tests/assets/**", "user/tests/build/assets/**", "mentor/tests/build/assets/**",
				"mentor/tests/assets/**",
				"guest/assets/**",
				"guest/tests/assets/**", "moderator/assets/**", "moderator/questions/assets/**")
		.addResourceLocations("/assets/");
		registry.setOrder(-1);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		registry.addInterceptor(localeChangeInterceptor);
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean(name="messageSource")
	public ReloadableResourceBundleMessageSource reloadableResourceBundle() {
		ReloadableResourceBundleMessageSource reloadableResourceBundle = new ReloadableResourceBundleMessageSource();
		reloadableResourceBundle.setBasenames("/WEB-INF/locales/messages");
		reloadableResourceBundle.setDefaultEncoding("UTF-8");
		reloadableResourceBundle.setFallbackToSystemLocale(false);
		return reloadableResourceBundle;
	}

	@Bean(name="localeResolver")
	public SessionLocaleResolver sessionLocaleResolver() {
		return new SessionLocaleResolver();
	}

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.mail.ru");
		mailSender.setPort(465);

		mailSender.setUsername("testyourself.application@mail.ru");
		mailSender.setPassword("mdq11235813");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtps");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");


		return mailSender;
	}

}

//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		converters.add(mappingJackson2HttpMessageConverter());
//	}
//
//	@Bean
//	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
//		return new MappingJackson2HttpMessageConverter();
//	}
