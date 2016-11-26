package br.edu.ifpb.ws.analyzerQuestionsRESTful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.filter.TokenFilter;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@SpringBootApplication
public class AnalyzerQuestionsRESTfulApplication extends SpringBootServletInitializer {

	@Bean
	public FilterRegistrationBean filterJwt() {

		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new TokenFilter());
		filterRegistrationBean.addUrlPatterns("/admin/*");

		return filterRegistrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(AnalyzerQuestionsRESTfulApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AnalyzerQuestionsRESTfulApplication.class);
	}
}