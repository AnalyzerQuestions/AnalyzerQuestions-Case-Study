package br.edu.ifpb.ws.analyzerQuestionsRESTful.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.ChosenQuestionsWrapper;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Question;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.QuestionWrapper;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.services.AnalyzerQuestionService;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.so.QuestionPojo;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.so.SOClient;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 * @author <a href="https://github.com/JoseRafael97">José Rafael</a>
 *
 */
@RestController
// @RequestMapping(AnalyzerQuestionController.BASE_URI)
public class AnalyzerQuestionController {

	public static final String BASE_URI = "/analyzer";

	// So para teste
	private List<Question> choicesQuestions;

	private AnalyzerQuestionService service;

	public AnalyzerQuestionController() {
		service = new AnalyzerQuestionService();
	}

	/**
	 * Analisa a pergunta passada e retorna uma lista de sugestões para esta
	 * perunta.
	 * 
	 * @param question
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = BASE_URI)
	public ResponseEntity<List<String>> getSuggestions(@RequestBody Question question) {

		List<String> suggestions = service.getSuggestions(question);
		return new ResponseEntity<List<String>>(suggestions, HttpStatus.OK);
	}

	/**
	 * Obtém um wrapper de uma pergunta, contendo a pergunta e lista de
	 * sugestões desta pergunta.
	 * 
	 * @param questionWrapper
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = BASE_URI + "/suggestions")
	public ResponseEntity<QuestionWrapper> registerChosenSuggestios(@RequestBody QuestionWrapper questionWrapper) {

		System.out.println(questionWrapper);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = BASE_URI + "/getQuestions")
	public ResponseEntity<List<Question>> getQuestions() {

		List<Question> questions = new ArrayList<>();
		SOClient soClient = new SOClient();

		for (QuestionPojo questionPojo : soClient.getQuestions()) {
			Question q = new  Question();
			q.setDescription(questionPojo.getBodyMarkdown());
			q.setTitle(questionPojo.getTitle());
			q.setTags(questionPojo.getTags());
			questions.add(q);
		}

		return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
	}

	/**
	 * 
	 * @param chosenQuestionW
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = BASE_URI + "/choices")
	public ResponseEntity<ChosenQuestionsWrapper> registerChosenQuestions(
			@RequestBody ChosenQuestionsWrapper chosenQuestionW) {

		System.out.println(chosenQuestionW);
		choicesQuestions = chosenQuestionW.getChosenQuestions();
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value=BASE_URI+"/getChoices")
	public ResponseEntity<List<Question>> getChosenQuestions(){
		
		if(choicesQuestions == null){
			choicesQuestions = new ArrayList<>();
		}
		return new ResponseEntity<>(choicesQuestions, HttpStatus.OK);
	}
}
