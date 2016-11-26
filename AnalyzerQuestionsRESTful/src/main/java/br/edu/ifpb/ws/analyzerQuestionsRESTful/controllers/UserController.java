package br.edu.ifpb.ws.analyzerQuestionsRESTful.controllers;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>	
 *
 */
@RestController
public class UserController {

	/**
	 * 
	 * @param key
	 * @return
	 * @throws ServletException
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/user/adminAccess")
	public LoginResponse access(@RequestParam("key") String key) throws ServletException {
		String keyStore = "adminAqtGQ";

		if (key.equals(keyStore)) {
			String token =  Jwts.builder()
					.setSubject(keyStore)
					.signWith(SignatureAlgorithm.HS512, "banana")
					.setExpiration(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
					.compact();
			
			
			return	new LoginResponse(token);
		} else {
			throw new ServletException("Token inválido.");
		}

	}

	/**
	 * 
	 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>	
	 *
	 */
	private class LoginResponse {
		public String token;

		public LoginResponse(String token) {
			this.token = token;
		}
	}

}
