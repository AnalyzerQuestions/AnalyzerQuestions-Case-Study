package br.edu.ifpb.ws.analyzerQuestionsRESTful.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Question;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.services.AnalyzerQuestionService;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>	
 * @author <a href="https://github.com/JoseRafael97">José Rafael</a>	
 *
 */
@RestController
@RequestMapping(AnalyzerQuestionController.BASE_URI)
public class AnalyzerQuestionController {
	
	public static final String BASE_URI = "/analyzer";
	
	private AnalyzerQuestionService service;

	public AnalyzerQuestionController() {
		service = new AnalyzerQuestionService();
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> getSuggestions(@RequestBody Question question){
		
		System.out.println(question);
		List<String> suggestions = service.getSuggestions(question);
		
		return new ResponseEntity<List<String>>(suggestions, HttpStatus.OK);
	}
	
	
}
