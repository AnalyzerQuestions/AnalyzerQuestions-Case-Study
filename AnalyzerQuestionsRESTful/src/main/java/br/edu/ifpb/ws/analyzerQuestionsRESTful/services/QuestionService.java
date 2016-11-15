package br.edu.ifpb.ws.analyzerQuestionsRESTful.services;

import java.util.List;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Question;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.util.data.ReaderQuestions;
import opennlp.maxent.Main;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class QuestionService {

	private AnalyzerQuestionSuggestion analyzer;
	private AnalyzerQuestion analyzerQuestion;

	public QuestionService() {
		analyzer = new AnalyzerQuestionSuggestion();
		analyzerQuestion = new AnalyzerQuestion();
	}

	public List<Question> getQuestions() {
		ReaderQuestions rq = new ReaderQuestions("perguntas.csv");
		List<Question> questions = rq.readCsvFile();

		for (Question q : questions) {
			
		}

		return questions;
	}
	
	public Float goodQuestionAverage(){
		ReaderQuestions rq = new ReaderQuestions("perguntas.csv");
		List<Question> questions = rq.readCsvFile();

		int cont = 0;
		for (Question q : questions) {
			if(goodQuestion(q)==1){
				cont++;
			}
		}

		System.out.println(questions.size());
		Float average = (float) ((cont*100)/questions.size());
		return average;
	}

	private Integer goodQuestion(Question question) {
		return analyzerQuestion.getGoodQuestionAnalyzer(question);
	}

	public List<String> getAnalize(Question question) {
		return analyzer.getSuggestions(question);
	}
	
	
	public static void main(String[] args) {
		QuestionService qu = new QuestionService();
		
		System.out.println(qu.goodQuestionAverage());
	}
}
