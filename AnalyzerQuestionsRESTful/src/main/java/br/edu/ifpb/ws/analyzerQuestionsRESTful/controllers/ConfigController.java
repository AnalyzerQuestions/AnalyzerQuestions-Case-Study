package br.edu.ifpb.ws.analyzerQuestionsRESTful.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Suggestion;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.pojos.Config;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.services.SuggestionService;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.util.data.FileOperationUtil;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>	
 *
 */
@RestController
public class ConfigController {
	
	@Autowired
	private SuggestionService service;
	
	FileOperationUtil fileOperationUtil = new FileOperationUtil();
	/**
	 * 
	 * @param config
	 * @return
	 */
	@RequestMapping(value = "/config", method = RequestMethod.POST)
	public ResponseEntity<Config> updateConfig(@RequestBody Config config) {
		
		Gson gson  = new Gson();
		String json = gson.toJson(config);
		fileOperationUtil.writer(json, "config.json");
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param config
	 * @return
	 */
	@RequestMapping(value = "/config", method = RequestMethod.GET)
	public ResponseEntity<String> getConfig() {
		
		String json = fileOperationUtil.reader("config.json");
		
		return new ResponseEntity<>(json, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param suggestion
	 * @return
	 */
	@RequestMapping(value="/suggestions", method=RequestMethod.POST)
	public ResponseEntity<Suggestion> saveSuggestion(@RequestBody Suggestion suggestion){
		
		Suggestion suggestionSaved = service.save(suggestion);
		
		return new ResponseEntity<Suggestion>(suggestionSaved, HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/suggestions", method=RequestMethod.PUT)
	public ResponseEntity<Suggestion> updateSuggestion(@RequestBody Suggestion suggestion){

		Suggestion suggestionUpdated = service.save(suggestion);
		
		return new ResponseEntity<Suggestion>(suggestionUpdated, HttpStatus.OK);
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/suggestions", method=RequestMethod.GET)
	public ResponseEntity<List<Suggestion>> findAllSuggestions(){

		List<Suggestion> suggestions = service.findAll();
		
		return new ResponseEntity<List<Suggestion>>(suggestions, HttpStatus.OK);
	}
}
