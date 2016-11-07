package br.edu.ifpb.ws.analyzerQuestionsRESTful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.QuestionWrapper;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>	
 *
 */
public interface QuestionWrapperRepository extends JpaRepository<QuestionWrapper, Long>{

}
