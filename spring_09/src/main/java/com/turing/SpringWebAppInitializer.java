package com.turing;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.turing.config.RootConfig;
import com.turing.config.WebConfig;

/**
 * 初始化SpringWeb应用，其中初始化DispatcherServlet和所有配置项
 * @author fred
 *
 */
public class SpringWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	//全局配置项
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {RootConfig.class};
	}

	//配置SpringMVC
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebConfig.class};
	}

	//配置ServletMapping
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
}
