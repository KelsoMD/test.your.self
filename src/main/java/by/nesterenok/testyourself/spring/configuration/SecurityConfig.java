package by.nesterenok.testyourself.spring.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
@ComponentScan("by.nesterenok.testyourself.spring.configuration")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    SuccessHandler successHandler;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        http.addFilterBefore(filter,CsrfFilter.class);
        http.csrf().disable();
        http.logout()
            .logoutSuccessUrl("/guest")
            .clearAuthentication(true)
            .invalidateHttpSession(true)
            .and();
        http.authorizeRequests()
            .antMatchers("/user/**")
            .hasRole("USER")
            .antMatchers("/moderator/**")
            .hasRole("MODERATOR")
            .antMatchers("/mentor/**")
            .hasRole("MENTOR")
            .antMatchers("/admin/**")
            .hasRole("ADMIN");
        http.formLogin()
            .loginPage("/login")
            .failureForwardUrl("/not_implemented")
            .permitAll()
            .usernameParameter("user_login")
            .passwordParameter("password_login")
            .failureForwardUrl("/login?error=true")
            .successHandler(successHandler)
            .isCustomLoginPage();
        http.httpBasic();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER").and()
//        .withUser("mentor").password("mentor").roles("MENTOR").and()
//        .withUser("quest").password("quest").roles("GUEST");
//
//    }

        @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(this.dataSource())
            .usersByUsernameQuery("select login, pass, enabled from users where login=?")
            .authoritiesByUsernameQuery("select login, role from users where login =?");
    }

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataSource.setUrl(
            "jdbc:mysql://localhost/testyourself?useTimezone=true&serverTimezone=UTC&useSSL=false");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("root");
        return driverManagerDataSource;
    }
}
