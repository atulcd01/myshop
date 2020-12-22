package com.ecomm.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

	  auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
			"select email , password, enabled from system_user where email = ?")
		.authoritiesByUsernameQuery(
			"select u.email , u.user_role as role from system_user u where u.email = ?");
	
	}

	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();
		
		http.authorizeRequests()
		//.antMatchers("/protected/order/**").hasRole("USER")
		.antMatchers("/**").permitAll()                  
		.anyRequest().authenticated()
		.and()
			.formLogin()
			.loginPage("/login").permitAll()
			.defaultSuccessUrl("/protected/home")
			.failureUrl("/login?error=403")
			.usernameParameter("username").passwordParameter("password")				
			.and()
			.logout().logoutSuccessUrl("/login")
			.logoutSuccessUrl("/login") 
			.invalidateHttpSession(true)
			.and().rememberMe(). 
            key("rem-me-key").
            rememberMeParameter("remember-me-param").
            rememberMeCookieName("my-remember-me").
            tokenValiditySeconds(86400);
			
		http.headers().frameOptions().disable();
		http.headers().frameOptions().sameOrigin();
		
	}
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
		db.setDataSource(dataSource);
		return db;
	}

	@Bean
	public SavedRequestAwareAuthenticationSuccessHandler
                savedRequestAwareAuthenticationSuccessHandler() {

               SavedRequestAwareAuthenticationSuccessHandler auth
                    = new SavedRequestAwareAuthenticationSuccessHandler();
		auth.setTargetUrlParameter("targetUrl");
		return auth;
	}
	
}