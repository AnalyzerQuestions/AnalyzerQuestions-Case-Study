package br.edu.ifpb.ws.analyzerQuestionsRESTful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Question;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>	
 *
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{

}
