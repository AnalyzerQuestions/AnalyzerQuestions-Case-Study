package br.edu.ifpb.ws.analyzerQuestionsRESTful.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.analyzers.QuestionAnalyzerFinal;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.analyzers.QuestionAnalyzerMSG;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Question;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.pojos.MSG;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Service
public class AnalyzerQuestionService {

	@Autowired
	private QuestionAnalyzerMSG analyzerMSG;
	
	private QuestionAnalyzerFinal questionAnalyzer;
	
	private List<MSG> suggestionsMap = new ArrayList<>();
	
	private MSG msg;
	
	
	public AnalyzerQuestionService() {
		
	}

	public List<MSG> getSuggestions(Question question) {
		suggestionsMap.clear();

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

		return suggestionsMap;
	}

	public void analyseUnderstandableTitle(String title, String description) {
		msg = analyzerMSG.msgUnderstandableTitle(title, description);
		if(msg.getHeader() != null){
			suggestionsMap.add(msg);
		}
	}

	public void analyseCoherencyBodyAndTitle(String title, String description) {
		msg = analyzerMSG.msgCoherencyBodyAndTitle(title, description);
		if(msg.getHeader() != null){
			suggestionsMap.add(msg);
		}
	}

	public void analyzerObjective(String description) {
		msg = analyzerMSG.msgObjective(description);
		if(msg.getHeader() != null){
			suggestionsMap.add(msg);
		}
	}

	public void analyzerClarity(String title, String description) {
		msg = analyzerMSG.msgClarity(title, description);
		if(msg.getHeader() != null){
			suggestionsMap.add(msg);
		}
	}

	public void analyseShowingExample(String description) {
		msg = analyzerMSG.msgExample(description);
		if(msg.getHeader() != null){
			suggestionsMap.add(msg);
		}
	}

	public void analyzerUnderstandableDescription(String title, String description) {
		msg = analyzerMSG.msgUnderstandableDescription(title, description);
		if(msg.getHeader() != null){
			suggestionsMap.add(msg);
		}
	}

	public void analyzerUsingProperLanguage(String description) {
		msg =analyzerMSG.msgUsingProperLanguage(description);
		if(msg.getHeader() != null){
			suggestionsMap.add(msg);
		}
	}

	public void analyzerBeEducated(String description) {
		msg = analyzerMSG.msgBeEducated(description);
		if(msg.getHeader() != null){
			suggestionsMap.add(msg);
		}
	}

	public void analyzerShortDescriptionQuestion(String description) {
		msg = analyzerMSG.msgShortDescriptionQuestion(description);
		if(msg.getHeader() != null){
			suggestionsMap.add(msg);
		}
	}

	public void analyzerDoNotCreateHomeworkQuestions(String description) {
		msg = analyzerMSG.msgDoNotCreateHomeworkQuestions(description);
		if(msg.getHeader() != null){
			suggestionsMap.add(msg);
		}
	}

	public QuestionAnalyzerFinal getQuestionAnalyzer() {
		return questionAnalyzer;
	}

	public void setQuestionAnalyzer(QuestionAnalyzerFinal questionAnalyzer) {
		this.questionAnalyzer = questionAnalyzer;
	}

}
