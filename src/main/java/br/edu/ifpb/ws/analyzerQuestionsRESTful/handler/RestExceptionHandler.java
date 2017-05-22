package br.edu.ifpb.ws.analyzerQuestionsRESTful.handler;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.dto.ResponseErrorDTO;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.exception.UniqueConstraintException;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.rest.UserRestService;

/**
 * 
 * <p>
 * {@link RestExceptionHandler}
 * </p>
 * 
 * <p>
 * Classe utilizada para controle de exceções não taradas pela API. Utiliza
 * {@link ControllerAdvice}
 * </p>
 *
 * <pre>
 * </pre
 *
 * @author <a href="https://franckaj.github.io">Franck Aragão</a>
 *
 */
@ControllerAdvice(basePackageClasses = { UserRestService.class })
public class RestExceptionHandler {

	/**
	 * Handler de erro para tratamento de exceções do {@link BeanValidation}
	 * 
	 * @param req
	 * 
	 * @param manvex
	 * 
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public ResponseEntity<List<String>> handlerErrorValidation(HttpServletRequest req,
			MethodArgumentNotValidException manvex) {

		List<ObjectError> errors = manvex.getBindingResult().getAllErrors();
		Iterator<ObjectError> iterator = errors.iterator();

		List<String> messages = new ArrayList<>();

		while (iterator.hasNext()) {
			messages.add(iterator.next().getDefaultMessage());
		}

		ResponseEntity<List<String>> responseEntity = new ResponseEntity<>(messages, HttpStatus.UNPROCESSABLE_ENTITY);

		return responseEntity;
	}

	/**
	 * 
	 * <p>
	 * Tratammento de erro para exceção {@link UniqueConstraintAlreadyException}
	 * </p>
	 * 
	 * @param e
	 * 
	 * @return
	 */
	@ExceptionHandler(UniqueConstraintException.class)
	@ResponseBody
	public ResponseEntity<ResponseErrorDTO> handleUniqueConstraintAlreadyException(UniqueConstraintException e) {
		return ResponseEntity.unprocessableEntity().body(new ResponseErrorDTO(e.getMessage()));
	}
	
	

}