package cuckoo.web;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/*
 * This class is used to load the web application related pages and for dispatching the rest mapping to the serber. 
 */

@EnableWebMvc
@Configuration
public class WebConfig  extends WebMvcConfigurerAdapter {
	
	 @Bean
	 public static PropertySourcesPlaceholderConfigurer PropertyConfigInDev() {
		 return new PropertySourcesPlaceholderConfigurer();
	 }

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("resources/**").addResourceLocations("static").setCachePeriod(0);
	}
//	@Bean(name = "multipartResolver")
//	public CommonsMultipartResolver commonsMultipartResolver() {
//		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
//		commonsMultipartResolver.setDefaultEncoding("utf-8");
//		commonsMultipartResolver.setMaxInMemorySize(500000000);
//		return commonsMultipartResolver;
//	}
}