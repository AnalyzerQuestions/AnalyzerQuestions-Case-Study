package br.edu.ifpb.ws.analyzerQuestionsRESTful.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Question;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.repository.QuestionRepository;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>	
 *
 */
@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	private AnalyzerQuestion analyzer;
	
	public QuestionService() {
		analyzer = new AnalyzerQuestion();
	}
	
	public Question save(Question question) {
		return questionRepository.save(question);
	}
	
	public List<String> getAnalize(Question question){
		return analyzer.getSuggestions(question);
		
	}
}
