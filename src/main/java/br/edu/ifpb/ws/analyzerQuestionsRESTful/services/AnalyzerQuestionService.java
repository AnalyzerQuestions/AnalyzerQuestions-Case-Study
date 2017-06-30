package br.edu.ifpb.ws.analyzerQuestionsRESTful.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.analyzers.QuestionAnalyzerFinal;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.analyzers.QuestionAnalyzerMSG;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.dto.MsgDTO;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.Question;

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
	
	private List<MsgDTO> suggestionsMap = new ArrayList<>();
	
	private MsgDTO msg;
	
	
	public AnalyzerQuestionService() {
		
	}

	public List<MsgDTO> getSuggestions(Question question) {
		suggestionsMap.clear();

		questionAnalyzer = new QuestionAnalyzerFinal();

		this.analyzerObjective(question.getDescription());
		this.analyzerClarity(question.getTitle(), question.getDescription());
		this.analyzerUnderstandableDescription(question.getTitle(), question.getDescription());
		this.analyzerBeEducated(question.getDescription());

		return suggestionsMap;
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

	public void analyzerUnderstandableDescription(String title, String description) {
		msg = analyzerMSG.msgUnderstandableDescription(title, description);
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

	public QuestionAnalyzerFinal getQuestionAnalyzer() {
		return questionAnalyzer;
	}

	public void setQuestionAnalyzer(QuestionAnalyzerFinal questionAnalyzer) {
		this.questionAnalyzer = questionAnalyzer;
	}

}
