package org.idb.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class AppDisServ extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {SpringRootConfig.class};
		
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {SpringConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};
	}

	
	
	public void onStartup(ServletContext context) throws ServletException {
		 super.onStartup(context);
		
	}
	
}
