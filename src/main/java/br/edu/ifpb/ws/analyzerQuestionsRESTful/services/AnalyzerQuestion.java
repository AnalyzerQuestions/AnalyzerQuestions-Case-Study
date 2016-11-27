package br.edu.ifpb.ws.analyzerQuestionsRESTful.services;


import br.edu.ifpb.ws.analyzerQuestionsRESTful.analyzers.QuestionAnalyzerFinal;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Question;

public class AnalyzerQuestion {
	
	private QuestionAnalyzerFinal questionAnalyzer;
	
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
