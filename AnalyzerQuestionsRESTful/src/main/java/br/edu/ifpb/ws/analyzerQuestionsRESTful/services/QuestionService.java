package br.edu.ifpb.ws.analyzerQuestionsRESTful.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.ChosenQuestionsWrapper;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Question;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.QuestionWrapper;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.repository.ChosenQuestionsWrapperRepository;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.repository.QuestionRepository;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.repository.QuestionWrapperRepository;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>	
 *
 */
@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private QuestionWrapperRepository questionWrapperRepository;
	
	@Autowired
	private ChosenQuestionsWrapperRepository chosenQuestionsWrapperRepository;
	
	private AnalyzerQuestion analyzer;
	
	public QuestionService() {
		analyzer = new AnalyzerQuestion();
	}
	
	public Question saveOriginal(Question question) {
		return questionRepository.save(question);
	}
	
	public QuestionWrapper saveWithSuggestions(QuestionWrapper questionWrapper) {
		return questionWrapperRepository.save(questionWrapper);
	}
	
	public ChosenQuestionsWrapper saveChosenQuestions(ChosenQuestionsWrapper chosenQuestionsWrapper) {
		return chosenQuestionsWrapperRepository.save(chosenQuestionsWrapper);
	}
	
	public List<String> getAnalize(Question question){
		return analyzer.getSuggestions(question);
	}
}
