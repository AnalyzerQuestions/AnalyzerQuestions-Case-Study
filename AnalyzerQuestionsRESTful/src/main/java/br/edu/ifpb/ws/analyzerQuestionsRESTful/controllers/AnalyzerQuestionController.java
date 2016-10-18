package br.edu.ifpb.ws.analyzerQuestionsRESTful.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>	
 *
 */
@RestController
@RequestMapping(AnalyzerQuestionController.BASE_URI)
public class AnalyzerQuestionController {
	
	public static final String BASE_URI = "/analyzer";
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String analyzerQuestion(){
		return "hello world ws!";
	}
}
