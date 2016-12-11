package br.edu.ifpb.ws.analyzerQuestionsRESTful.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Question;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.services.QuestionService;

/**
 * 
 * <p>
 * <b> End point de acesso a métodos de uma pergunta.</b>
 * </p>
 *
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@RestController
public class QuestionController {
	
	public static final String BASE_URI = "/questions";
	
	@Autowired
	private QuestionService questionService;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = BASE_URI+"/{id}")
	public ResponseEntity<Question> findById(@PathVariable Long id){
		Question question = questionService.findById(id); 
		return new ResponseEntity<Question>(question, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param question
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT, value= BASE_URI)
	public ResponseEntity<Question> update(@RequestBody Question question) {
		
		Question questionUpdated = questionService.update(question);
		return new ResponseEntity<Question>(questionUpdated, HttpStatus.OK);
	}
}
