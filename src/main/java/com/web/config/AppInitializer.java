package com.web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		/* KZN
		 * Just like web.xml tell the AppInitializer
		 * that where is the Configuration for working with database
		 * this was done using applicationContext.xml in project 1
		 * so this has to be present
		 * */
		return new Class [] {AppConfig.class};
        //return new Class [] {DBConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] { "/" };
	}

}
