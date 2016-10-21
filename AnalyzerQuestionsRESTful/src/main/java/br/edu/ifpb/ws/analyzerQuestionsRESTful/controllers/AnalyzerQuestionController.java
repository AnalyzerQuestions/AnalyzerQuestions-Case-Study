package br.edu.ifpb.ws.analyzerQuestionsRESTful.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Question;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.QuestionWrapper;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.services.AnalyzerQuestionService;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>	
 * @author <a href="https://github.com/JoseRafael97">José Rafael</a>	
 *
 */
@RestController
//@RequestMapping(AnalyzerQuestionController.BASE_URI)
public class AnalyzerQuestionController {
	
	public static final String BASE_URI = "/analyzer";
	
	private AnalyzerQuestionService service;

	public AnalyzerQuestionController() {
		service = new AnalyzerQuestionService();
	}
	
	/**
	 * Analisa a pergunta passada e retorna uma lista de sugestões
	 * para esta perunta.
	 * 
	 * @param question
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = BASE_URI)
	public ResponseEntity<List<String>> getSuggestions(@RequestBody Question question){
		
		List<String> suggestions = service.getSuggestions(question);
		return new ResponseEntity<List<String>>(suggestions, HttpStatus.OK);
	}
	
	/**
	 * Obtém um wrapper de uma pergunta, contendo a pergunta e lista de sugestões desta pergunta.
	 * 
	 * @param questionWrapper
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value=BASE_URI+"/suggestions")
	public ResponseEntity<QuestionWrapper> registerChosenSuggestios(@RequestBody QuestionWrapper questionWrapper){
		
		System.out.println(questionWrapper);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value= BASE_URI+"/getQuestions")
	public ResponseEntity<List<Question>> getQuestions(){
		
		List<Question> questions = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			Question q = new Question();
			q.setTitle("Titulo da pergunta de programação "+ i);
			q.setDescription("Esta é uma descrição de uma pergunta de programação, utilizada como teste para o front-end desta aplicação."
					+ "IFPB - Campus Monteiro - bla bla ...");
			
			q.setMarkdownDescription("<code>");
			questions.add(q);
		}
		return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
	}
}
