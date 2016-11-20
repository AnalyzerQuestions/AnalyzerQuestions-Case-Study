package br.edu.ifpb.ws.analyzerQuestionsRESTful.services;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.analyzers.QuestionAnalyzerFinal;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.analyzers.QuestionAnalyzerMSG;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.MSG;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Question;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class AnalyzerQuestionSuggestion {

	private QuestionAnalyzerFinal questionAnalyzer;
	private QuestionAnalyzerMSG analyzerMSG;
	private List<MSG> suggestionsMap = new ArrayList<>();

	public List<MSG> getSuggestions1(Question question) {
		suggestionsMap.clear();

		questionAnalyzer = new QuestionAnalyzerFinal();
		analyzerMSG = new QuestionAnalyzerMSG();

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

		return suggestionsMap;
	}

	public void analyseUnderstandableTitle(String title, String description) {
		suggestionsMap.add(analyzerMSG.msgUnderstandableTitle(title, description));
	}

	public void analyseCoherencyBodyAndTitle(String title, String description) {
		suggestionsMap.add(analyzerMSG.msgCoherencyBodyAndTitle(title, description));
	}

	public void analyzerObjective(String description) {
		suggestionsMap.add(analyzerMSG.msgObjective(description));
	}

	public void analyzerClarity(String title, String description) {
		suggestionsMap.add(analyzerMSG.msgClarity(title, description));
	}

	public void analyseShowingExample(String description) {
		suggestionsMap.add(analyzerMSG.msgExample(description));
	}

	public void analyzerUnderstandableDescription(String title, String description) {
		suggestionsMap.add(analyzerMSG.msgUnderstandableDescription(title, description));
	}

	public void analyzerUsingProperLanguage(String description) {
		suggestionsMap.add(analyzerMSG.msgUsingProperLanguage(description));
	}

	public void analyzerBeEducated(String description) {
		suggestionsMap.add(analyzerMSG.msgBeEducated(description));
	}

	public void analyzerShortDescriptionQuestion(String description) {
		suggestionsMap.add(analyzerMSG.msgShortDescriptionQuestion(description));
	}

	public void analyzerDoNotCreateHomeworkQuestions(String description) {
		suggestionsMap.add(analyzerMSG.msgDoNotCreateHomeworkQuestions(description));
	}

	public QuestionAnalyzerFinal getQuestionAnalyzer() {
		return questionAnalyzer;
	}

	public void setQuestionAnalyzer(QuestionAnalyzerFinal questionAnalyzer) {
		this.questionAnalyzer = questionAnalyzer;
	}

}
