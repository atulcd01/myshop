package com.ecomm.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.ecomm.interceptor.LoginInterceptor;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/staticimages/**").addResourceLocations("file:/home/atul/atulcd01/img/");
	}
	
	@Bean
    public MessageSource messageSource() {

        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("WEB-INF/i18n");
        // if true, the key of the message will be displayed if the key is not
        // found, instead of throwing a NoSuchMessageException
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setDefaultEncoding("UTF-8");
        // # -1 : never reload, 0 always reload
        messageSource.setCacheSeconds(0);
        return messageSource;
    }
	
	
    @Bean
    public LocaleResolver localeResolver(){
	CookieLocaleResolver resolver = new CookieLocaleResolver();
	resolver.setDefaultLocale(new Locale("en"));
	resolver.setCookieName("myLocaleCookie");
	resolver.setCookieMaxAge(4800);
	return resolver;
    }
    
    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
	LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
	interceptor.setParamName("mylocale");
	registry.addInterceptor(interceptor);
	registry.addInterceptor(loginInterceptor());
    }

}
