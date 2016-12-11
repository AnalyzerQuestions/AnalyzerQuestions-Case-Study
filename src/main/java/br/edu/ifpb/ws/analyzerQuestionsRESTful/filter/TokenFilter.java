package br.edu.ifpb.ws.analyzerQuestionsRESTful.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Jwts;

/**
 * 
 * <p>
 * 		<b> Token Filter </b>
 * </p>
 *
 * <p>
 * 	Inteceptador para verificação de token passado para a API. 
 * </p>
 * 
 * <pre>
 *	@see <a href="https://github.com/jwtk/jjwt">JWT for java implementation</a>
 * </pre>
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class TokenFilter extends GenericFilterBean{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
			HttpServletRequest req = (HttpServletRequest) request;
			
			String header = req.getHeader("Authorization");
			
			if (header==null || !header.startsWith("Bearer ")){
				throw new ServletException("Token inexiste ou inválido");
			}
			
			String token = header.substring(7); 
			
			try{
				Jwts.parser().setSigningKey("banana").parseClaimsJws(token).getBody();
				chain.doFilter(request, response);
			}catch(Exception e){
				((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token Inválido!");

			}
	}
}
