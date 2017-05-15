package br.edu.ifpb.ws.analyzerQuestionsRESTful.rest;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 
 * <p>
 * 		<b> User Controller </b>
 * </p>
 *
 * <p>
 * 		Gera token de acesso para páginas de admin.
 * 		Utilizando especificação Json web token.
 * </p>
 * 
 * <pre>
 *	@see <a href="https://github.com/jwtk/jjwt">JWT for java implementation</a>
 * </pre>
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@RestController
public class AdminRestService {
	
	@Value("${aqt.jwt.sc}")
	private String keyStore;
	
	@Value("${aq.jwt.secret}")
	private String keySecret;

	/**
	 * 
	 * @param key of access
	 * 
	 * @return token with information of user.
	 * 
	 * @throws ServletException
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/user/adminAccess")
	public LoginResponse access(@RequestParam("key") String key) throws ServletException {
		String keyStore = "teste";

		if (key.equals(keyStore)) {
			String token =  Jwts.builder()
					.setSubject(keyStore)
					.signWith(SignatureAlgorithm.HS512, "banana")
					.setExpiration(new Date(System.currentTimeMillis() + 180 * 60 * 1000))
					.compact();
			
			return	new LoginResponse(token);
		} else {
			throw new ServletException("Token inválido.");
		}

	}

/**
 * 
 * <p>
 * 		<b> Login Response </b>
 * </p>

 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
	private class LoginResponse {
		@SuppressWarnings("unused")
		public String token;

		/**
		 * 
		 * @param token
		 */
		public LoginResponse(String token) {
			this.token = token;
		}
	}
}
