package cuckoo.web;
import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 * This class is used to dispatch our application on server. 
 */

public class SpringMvcInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	 @Override 
	 protected Class<?>[] getRootConfigClasses(){
		 return new Class[] { CuckoWebApplication.class};
	 }
	 
	 @Override 
	 protected Class<?>[] getServletConfigClasses(){
		 return null;
	 }

	 @Override
	 protected String[] getServletMappings() {
		 return new String[] { "/" };
	 }
	 
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		int lstIndex = servletContext.getRealPath(File.separator).lastIndexOf(File.separator);
		String currentDir = servletContext.getRealPath(File.separator).substring(0,lstIndex);
		System.setProperty("currentDir",currentDir);
	}
}