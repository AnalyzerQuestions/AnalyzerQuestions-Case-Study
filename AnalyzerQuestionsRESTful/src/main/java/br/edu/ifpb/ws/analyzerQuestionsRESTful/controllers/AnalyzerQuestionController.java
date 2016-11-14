package br.edu.ifpb.ws.analyzerQuestionsRESTful.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Question;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Usuario;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.enumerations.QuestionType;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.services.QuestionService;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.services.UserService;

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

	private QuestionService questionService = new QuestionService();
	
	@Autowired
	private UserService userService;
	
	private List<Question> chosenQuestions;
	



	/**
	 * Analisa a pergunta passada e retorna uma lista de sugestões para esta
	 * perunta.
	 * 
	 * @param usuario
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = BASE_URI)
	public ResponseEntity<List<String>> getSuggestions(@RequestBody Usuario usuario) {
		usuario.getQuestion().setQuestionType(QuestionType.ORIGINAL);
		
		List<String> suggestions = questionService.getAnalize(usuario.getQuestion());
		
		return new ResponseEntity<List<String>>(suggestions, HttpStatus.OK);
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = BASE_URI + "/getQuestions")
	public ResponseEntity<List<Question>> getQuestions() {

		List<Question> questions = questionService.getQuestions();

		return new ResponseEntity<List<Question>>(questions, HttpStatus.OK);
	}

	/**
	 * 
	 */
	@RequestMapping(method = RequestMethod.GET, value = BASE_URI + "/getChonseQuestions")
	public ResponseEntity<List<Question>> getChosenQuestions() {

		if (chosenQuestions == null)  {
			chosenQuestions = new ArrayList<>();
		}

		return new ResponseEntity<List<Question>>(chosenQuestions, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = BASE_URI+"/user")
	public ResponseEntity<Usuario> RegisterUser(@RequestBody Usuario user){
		
		Usuario u = userService.saveUser(user);
		return new ResponseEntity<Usuario>(u, HttpStatus.OK);

	}
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT, value = BASE_URI+"/user")
	public ResponseEntity<Usuario> updateUser(@RequestBody Usuario user){
		Usuario u = userService.updateUser(user); 
		return new ResponseEntity<Usuario>(u, HttpStatus.OK);
		
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = BASE_URI+"/user/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable Long id){
			
		Usuario user = userService.getById(id);
		if(user == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}
