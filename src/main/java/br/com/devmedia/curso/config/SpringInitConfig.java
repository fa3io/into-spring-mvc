package br.com.devmedia.curso.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * Indica as classes da aplica��o que devem ser carregadas para efetuar configura��es 
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{SpringMvcConfig.class};
	}

	/**
	 * Efetua o mapeamentos dos servlets apartir e /
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

}
