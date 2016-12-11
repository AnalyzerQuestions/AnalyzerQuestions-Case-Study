package br.edu.ifpb.ws.analyzerQuestionsRESTful.repository;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Suggestion;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.enumerations.TSuggestions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * <p>
 * 		<b> Suggestion Repository</b>
 * </p>
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Repository
public interface SuggestionRepository extends JpaRepository<Suggestion, Long>{
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	Suggestion findByTipo(TSuggestions t);

}
