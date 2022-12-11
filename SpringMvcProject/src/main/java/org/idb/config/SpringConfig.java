package org.idb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = "org.idb")
@EnableWebMvc
public class SpringConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		// external resources like css, js, images
		super.addResourceHandlers(registry);
	}
	
	@Bean
	public ViewResolver resolver() {
		
		InternalResourceViewResolver rv=new InternalResourceViewResolver();
		
		rv.setViewClass(JstlView.class);
		
		rv.setPrefix("/WEB-INF/views/");
		rv.setSuffix(".jsp");
		
		return rv;
		
	}
	


}
