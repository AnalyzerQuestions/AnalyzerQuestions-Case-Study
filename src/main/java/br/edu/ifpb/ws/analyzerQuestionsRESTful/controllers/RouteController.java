package br.edu.ifpb.ws.analyzerQuestionsRESTful.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * <p>
 * 		<b> Router Controller </b>
 * </p>
 *
 * <p>
 * 	define o index como página inicial.
 * </p>
 * 
 * <pre>
 *		 @see utilizado paara definir o index como página inicial no angularJS. 
 * </pre>
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Controller
public class RouteController {
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/")
	public String loadIndex(){
		return "index";
	}
}
