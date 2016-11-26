package br.edu.ifpb.ws.analyzerQuestionsRESTful.controllers;

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
import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.pojos.MSG;
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

	@Autowired
	private QuestionService questionService;

	@Autowired
	private UserService userService;

	/**
	 * Analisa a pergunta passada e retorna uma lista de sugestões para esta
	 * perunta.
	 * 
	 * @param usuario
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = BASE_URI)
	public ResponseEntity<List<MSG>> getSuggestions(@RequestBody Usuario usuario) {
		usuario.getQuestion().setQuestionType(QuestionType.ORIGINAL);

		userService.updateUser(usuario);
		List<MSG> suggestions = questionService.getAnalize(usuario.getQuestion());
		return new ResponseEntity<List<MSG>>(suggestions, HttpStatus.OK);
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
	 * @param user
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = BASE_URI + "/user")
	public ResponseEntity<Usuario> RegisterUser(@RequestBody Usuario user) {

		Usuario u = userService.saveUser(user);
		return new ResponseEntity<Usuario>(u, HttpStatus.OK);

	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT, value = BASE_URI + "/user")
	public ResponseEntity<Usuario> updateUser(@RequestBody Usuario user) {
		Usuario u = userService.updateUser(user);
		return new ResponseEntity<Usuario>(u, HttpStatus.OK);

	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = BASE_URI + "/user/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable Long id) {
		Usuario user = userService.getById(id);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = BASE_URI + "/user")
	public ResponseEntity<List<Usuario>> findAll() {

		List<Usuario> users = userService.getAll();

		return new ResponseEntity<List<Usuario>>(users, HttpStatus.OK);
	}
}
