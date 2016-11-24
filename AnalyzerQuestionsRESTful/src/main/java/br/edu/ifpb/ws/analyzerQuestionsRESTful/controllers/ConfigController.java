package br.edu.ifpb.ws.analyzerQuestionsRESTful.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.pojos.Config;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.enumerations.Messages;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.util.data.FileOperationUtil;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>	
 *
 */
@RestController
public class ConfigController {
	
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
	 * @return
	 */
	@RequestMapping(value="/suggestions", method=RequestMethod.GET)
	public ResponseEntity<List<Messages>> getSuggestions(){
		
		List<Messages> messages = Arrays.asList(Messages.values());
		
		return new ResponseEntity<List<Messages>>(messages, HttpStatus.OK);
	}

}
