package br.edu.ifpb.ws.analyzerQuestionsRESTful.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.dto.MsgDTO;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Question;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Usuario;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.enumerations.QuestionType;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.services.QuestionService;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.services.UserService;

/**
 * 
 * <p>
 * 	<b> End point to feedback of a question </b>
 * </p>
 *
 * <p>
 * Descrição
 * </p>
 * 
 * <pre>
 * 		@see @UserController used for case study only.
 * </pre>
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@RestController
public class AnalyzerQuestionRestService {

	public static final String BASE_URI = "/analyzer";

	@Autowired
	private QuestionService questionService;

	@Autowired
	private UserService userService;

	/**
	 * Analisa a pergunta passada e retorna uma lista de sugestões para esta
	 * perunta. Registra metadados do usuário no BD para análises posteriomente.
	 * 
	 * Método utilizado para estudo de caso apenas.
	 * 
	 * @param usuario
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = BASE_URI)
	public ResponseEntity<List<MsgDTO>> getSuggestions(@RequestBody Usuario usuario) {
		usuario.getQuestion().setQuestionType(QuestionType.ORIGINAL);

		userService.updateUser(usuario);
		List<MsgDTO> suggestions = questionService.getAnalize(usuario.getQuestion());
		return new ResponseEntity<List<MsgDTO>>(suggestions, HttpStatus.OK);
	}
	
	/**
	 * Endpoint retorna uma lista de sugestões para uma pergunta passada.
	 * 
	 * @param question
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "analyzerOnly")
	public ResponseEntity<List<MsgDTO>> getSugestionOnly(@RequestBody Question question) {
		
		List<MsgDTO> suggestions = questionService.getAnalize(question);
		return new ResponseEntity<List<MsgDTO>>(suggestions, HttpStatus.OK);
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

}
