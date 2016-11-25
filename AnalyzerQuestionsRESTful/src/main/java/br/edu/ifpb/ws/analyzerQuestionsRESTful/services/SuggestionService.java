package br.edu.ifpb.ws.analyzerQuestionsRESTful.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Suggestion;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.enumerations.TSuggestions;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.repository.SuggestionRepository;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>	
 *
 */
@Service
public class SuggestionService {
	
	@Autowired
	private SuggestionRepository suggestionRepository;
	
	/**
	 * 
	 * @param suggestion
	 * @return
	 */
	@Transactional
	public Suggestion save(Suggestion suggestion){
		return suggestionRepository.save(suggestion);
	}
	
	/**
	 * 
	 * @return
	 */
	@Transactional
	public List<Suggestion> findAll(){
		return suggestionRepository.findAll();
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	@Transactional
	public Suggestion findByTipo(TSuggestions t){
		return suggestionRepository.findByTipo(t);
	}
}
