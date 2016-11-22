package br.edu.ifpb.ws.analyzerQuestionsRESTful.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {
	
	@RequestMapping(value = "/config", method = RequestMethod.PUT)
	public ResponseEntity<?> updateConfig(@RequestBody Config config) {
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
