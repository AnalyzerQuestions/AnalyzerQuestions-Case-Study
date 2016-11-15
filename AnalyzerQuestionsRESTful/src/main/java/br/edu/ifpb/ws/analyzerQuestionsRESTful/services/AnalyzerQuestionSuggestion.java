package br.edu.ifpb.ws.analyzerQuestionsRESTful.services;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.analyzers.QuestionAnalyzerFinal;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Question;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.enumerations.Messages;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>	
 *
 */
public class AnalyzerQuestionSuggestion {

	private QuestionAnalyzerFinal questionAnalyzer;
	private List<String> suggestions = new ArrayList<String>();

	public List<String> getSuggestions(Question question) {
		suggestions.clear();

		questionAnalyzer = new QuestionAnalyzerFinal();

		this.analyseUnderstandableTitle(question.getTitle(), question.getDescription());
		this.analyseCoherencyBodyAndTitle(question.getTitle(), question.getDescription());
		this.analyzerObjective(question.getDescription());
		this.analyzerClarity(question.getTitle(), question.getDescription());
		this.analyseShowingExample(question.getDescription());
		this.analyzerUnderstandableDescription(question.getTitle(), question.getDescription());
		this.analyzerBeEducated(question.getDescription());
		this.analyzerShortDescriptionQuestion(question.getDescription());
		this.analyzerDoNotCreateHomeworkQuestions(question.getDescription());
		this.analyzerUsingProperLanguage(question.getDescription());
		
		return suggestions;
	}

	public void analyseUnderstandableTitle(String title, String description) {
		if (questionAnalyzer.analyzerUnderstandableTitle(title, description) == 0)
			suggestions.add(Messages.TITULO_BEM_DEFINIDO.getMsg());
	}
	
	
	public void analyseCoherencyBodyAndTitle(String title, String description){
		if(questionAnalyzer.analyzerCoherencyBodyAndTitle(title, description) == 0)
			suggestions.add(Messages.COERENCY_BODY_WITH_TITLE.getMsg());
	}
	
	public void analyzerObjective(String description){
		if(questionAnalyzer.analyzerObjective(description) == 0)
			suggestions.add(Messages.IS_OBJECTIVE.getMsg());
	}
	
	public void analyzerClarity(String title, String description){
		if(questionAnalyzer.analyzerClarity(title, description) == 0)
			suggestions.add(Messages.IS_CLARITY.getMsg());
	}
	
	public void analyseShowingExample(String description){
		if(questionAnalyzer.analyzerShowExample(description) == 0)
			suggestions.add(Messages.SHOW_EXAMPLE.getMsg());
	}
	
	
	public void analyzerUnderstandableDescription(String title, String description){
		if(questionAnalyzer.analyzerUnderstandableDescription(title, description) == 0)
			suggestions.add(Messages.UNDESTANDABLE_DESCRTION.getMsg());
	}
	
	public void analyzerDetailAboutContext(String description){
		if(questionAnalyzer.analyzerDetailAboutContext(description) == 0)
			suggestions.add(Messages.DETAIL_CONTEXT.getMsg());
	}
	
	public void analyzerUsingProperLanguage(String description){
		if(questionAnalyzer.analyzerUsingProperLanguage(description) == 0)
			suggestions.add(Messages.USING_PROPER_LANGUAGE.getMsg());
	}
	
	public void analyzerBeEducated(String description){
		if(questionAnalyzer.analyzerBeEducated(description) == 0)
			suggestions.add(Messages.BE_EDUCADED.getMsg());
	}
	
	public void analyzerShortDescriptionQuestion(String description){
		if(questionAnalyzer.analyzerShortDescriptionQuestion(description) == 0)
			suggestions.add(Messages.SHORT_DESCRIPTION.getMsg());
	}
	
	public void analyzerDoNotCreateHomeworkQuestions(String description){
		if(questionAnalyzer.analyzerDoNotCreateHomeworkQuestions(description) == 0)
			suggestions.add(Messages.HOME_WORK_QUESTION.getMsg());
	}
	
	public List<String> getMessages() {
		return suggestions;
	}

	
	public void setMessages(List<String> messages) {
		this.suggestions = messages;
	}

	public QuestionAnalyzerFinal getQuestionAnalyzer() {
		return questionAnalyzer;
	}

	public void setQuestionAnalyzer(QuestionAnalyzerFinal questionAnalyzer) {
		this.questionAnalyzer = questionAnalyzer;
	}
	
}
