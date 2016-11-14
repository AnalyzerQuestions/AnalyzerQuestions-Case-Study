package br.edu.ifpb.ws.analyzerQuestionsRESTful.services;

import java.util.List;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Question;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.util.data.ReaderQuestions;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>	
 *
 */
public class QuestionService {
	
	private AnalyzerQuestion analyzer;
	
	public QuestionService() {
		analyzer = new AnalyzerQuestion();
	}
	
	public List<Question> getQuestions() {
		ReaderQuestions rq = new ReaderQuestions("perguntas.csv");
		List<Question> questions = rq.readCsvFile();
		
		return questions;
	}
	
	public List<String> getAnalize(Question question){
		return analyzer.getSuggestions(question);
	}
}
