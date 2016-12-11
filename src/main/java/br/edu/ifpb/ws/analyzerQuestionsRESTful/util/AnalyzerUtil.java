package br.edu.ifpb.ws.analyzerQuestionsRESTful.util;


import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.analyzers.QuestionAnalyzerFinal;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Question;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.util.data.ReaderQuestions;

/**
 * 
 * <p>
 * 		<b> Analyzer Util </b>
 * </p>
 *
 * <p>
 * 	Classe utilizada apenas para calcular percentual de 
 *	 pergunta "Boas" (a partir de 8 características).
 * </p>
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class AnalyzerUtil {
	
	private QuestionAnalyzerFinal questionAnalyzer;
	
	private final String CSV_READ = "perguntas.csv"; 
	
	private final String CSV_300_QUESTION = "perguntasOrder.csv"; 
	
	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private List<Question> ordenedQuestions(){
		
		List<Question> goodQuestions = new ArrayList<>();
		List<Question> badQuestions = new ArrayList<>();
		int cont = 0;
		
		ReaderQuestions rq = new ReaderQuestions(CSV_READ);
		List<Question> questions = rq.readCsvFile();

		for (Question q : questions) {
			if(getGoodQuestionAnalyzer(q)==1){
				goodQuestions.add(q);
			}else{
				badQuestions.add(q);
			}
		}
		
		questions = new ArrayList<>();
		
		for(int i = 0 ; i<300 ;i++){
			if(cont==11){
				cont =0;
			}
			
			if(cont<6){
				questions.add(goodQuestions.get(i));
			}else if(cont>5){
				questions.add(badQuestions.get(i));
			}
			
			cont++;
		}

		return questions;
	}
	
	/**
	 * 
	 * @return
	 */
	public Integer goodQuestionAverage(){
		ReaderQuestions rq = new ReaderQuestions(CSV_300_QUESTION);
		List<Question> questions = rq.readCsvFile();

		int cont = 0;
		for (Question q : questions) {
			if(getGoodQuestionAnalyzer(q)==1){
				cont++;
			}
		}

		return ((cont*100)/questions.size());
	}
	
	/**
	 * 
	 * @param question
	 * @return
	 */
	public Integer getGoodQuestionAnalyzer(Question question) {
		questionAnalyzer = new QuestionAnalyzerFinal();
		
		int cont = 0;

		cont = cont + this.analyseUnderstandableTitle(question.getTitle(), question.getDescription());
		cont = cont + this.analyseCoherencyBodyAndTitle(question.getTitle(), question.getDescription());
		cont = cont + this.analyzerObjective(question.getDescription());
		cont = cont + this.analyzerClarity(question.getTitle(), question.getDescription());
		cont = cont + this.analyseShowingExample(question.getDescription());
		cont = cont + this.analyzerUnderstandableDescription(question.getTitle(), question.getDescription());
		cont = cont + this.analyzerBeEducated(question.getDescription());
		cont = cont + this.analyzerShortDescriptionQuestion(question.getDescription());
		cont = cont + this.analyzerDoNotCreateHomeworkQuestions(question.getDescription());
		cont = cont + this.analyzerUsingProperLanguage(question.getDescription());
		cont = cont + this.analyzerDetailAboutContext(question.getDescription());
		
		if(cont > 7){
			return 1;
		}
		return 0;
	}

	public Integer analyseUnderstandableTitle(String title, String description) {
		return questionAnalyzer.analyzerUnderstandableTitle(title, description);
	}
	
	
	public Integer analyseCoherencyBodyAndTitle(String title, String description){
		return questionAnalyzer.analyzerCoherencyBodyAndTitle(title, description);
	}
	
	public Integer analyzerObjective(String description){
		return questionAnalyzer.analyzerObjective(description);
	}
	
	public Integer analyzerClarity(String title, String description){
		return questionAnalyzer.analyzerClarity(title, description);
	}
	
	public Integer analyseShowingExample(String description){
		return questionAnalyzer.analyzerShowExample(description);
	}
	
	
	public Integer analyzerUnderstandableDescription(String title, String description){
		return questionAnalyzer.analyzerUnderstandableDescription(title, description);
	}
	
	public Integer analyzerDetailAboutContext(String description){
		return questionAnalyzer.analyzerDetailAboutContext(description);
	}
	
	public Integer analyzerUsingProperLanguage(String description){
		return questionAnalyzer.analyzerUsingProperLanguage(description);
	}
	
	public Integer analyzerBeEducated(String description){
		return questionAnalyzer.analyzerBeEducated(description);
	}
	
	public Integer analyzerShortDescriptionQuestion(String description){
		return questionAnalyzer.analyzerShortDescriptionQuestion(description);
	}
	
	public Integer analyzerDoNotCreateHomeworkQuestions(String description){
		return questionAnalyzer.analyzerDoNotCreateHomeworkQuestions(description);
	}
	

	public QuestionAnalyzerFinal getQuestionAnalyzer() {
		return questionAnalyzer;
	}

	public void setQuestionAnalyzer(QuestionAnalyzerFinal questionAnalyzer) {
		this.questionAnalyzer = questionAnalyzer;
	}

}
