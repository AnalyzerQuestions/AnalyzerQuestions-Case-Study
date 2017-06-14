package br.edu.ifpb.ws.analyzerQuestionsRESTful.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Config;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Suggestion;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.repository.ConfigRepository;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.services.SuggestionService;

/**
 * 
 * <p>
 * <b> Configuration Controller </b>
 * </p>
 *
 * 
 * <pre>
 * &#64;see @ConfigController used for case study only
 * </pre>
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@RestController
public class ConfigRestService {

	@Autowired
	private SuggestionService service;

	@Autowired
	private ConfigRepository configRepository;

	/**
	 * 
	 * @param config
	 * @return
	 */
	@RequestMapping(value = "/admin/config", method = RequestMethod.POST)
	public ResponseEntity<Config> updateConfig(@RequestBody Config config) {

		configRepository.save(config);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * 
	 * @param config
	 * @return
	 */
	@RequestMapping(value = "/config", method = RequestMethod.GET)
	public ResponseEntity<Config> getConfig() {
		Config config = null;
		List<Config> configs = configRepository.findAll();
		if(configs != null && !configs.isEmpty()) {
			config = configs.get(0);
		}

		return new ResponseEntity<>(config, HttpStatus.OK);
	}

	/**
	 * 
	 * @param suggestion
	 * @return
	 */
	@RequestMapping(value = "/admin/suggestions", method = RequestMethod.POST)
	public ResponseEntity<Suggestion> saveSuggestion(@RequestBody Suggestion suggestion) {

		Suggestion suggestionSaved = service.save(suggestion);

		return new ResponseEntity<Suggestion>(suggestionSaved, HttpStatus.CREATED);
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/suggestions", method = RequestMethod.DELETE)
	public ResponseEntity<?> removeAll() {
		service.removeAll();
		return new ResponseEntity<>(HttpStatus.OK);

	};

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/suggestions", method = RequestMethod.PUT)
	public ResponseEntity<Suggestion> updateSuggestion(@RequestBody Suggestion suggestion) {

		Suggestion suggestionUpdated = service.save(suggestion);

		return new ResponseEntity<Suggestion>(suggestionUpdated, HttpStatus.OK);
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin/suggestions", method = RequestMethod.GET)
	public ResponseEntity<List<Suggestion>> findAllSuggestions() {

		List<Suggestion> suggestions = service.findAll();

		return new ResponseEntity<List<Suggestion>>(suggestions, HttpStatus.OK);
	}
}
