package br.edu.ifpb.ws.analyzerQuestionsRESTful;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>	
 * @author <a href="https://github.com/JoseRafael97">José Rafael</a>	

 *
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AnalyzerQuestionsRESTfulApplication.class);
	}

}
