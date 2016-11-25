package br.edu.ifpb.ws.analyzerQuestionsRESTful.repository;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Suggestion;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.enumerations.TSuggestions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>	
 *
 */
@Repository
public interface SuggestionRepository extends JpaRepository<Suggestion, Long>{
	
	Suggestion findByTipo(TSuggestions t);
	
	

}
