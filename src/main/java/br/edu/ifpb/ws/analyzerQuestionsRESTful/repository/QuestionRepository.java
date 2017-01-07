package br.edu.ifpb.ws.analyzerQuestionsRESTful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Question;

/**
 * 
 * <p>
 * 		<b> Question Repository </b>
 * </p>
 *
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public interface QuestionRepository extends JpaRepository<Question, Long>{

}
