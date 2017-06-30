package br.edu.ifpb.ws.analyzerQuestionsRESTful.analyzers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.dto.MsgDTO;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.enumerations.TSuggestions;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.services.SuggestionService;

/**
 * 
 * <p>
 * 		<b> Analizadores com Mensagens de feedback.</b>
 * </p>
 *
 * <p>
 * 	Classe Pojo para mensagens de feedback dos analizadores.
 * </p>
 * 
 * <pre>
 * 		Classe necessária apenas para estudo de caso.
 * </pre>
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Service
public class QuestionAnalyzerMSG {

	/**
	 * 
	 */
	private QuestionAnalyzerFinal qaf;
	
	/**
	 * 
	 */
	private List<String> messages;
	
	/**
	 * 
	 */
	private MsgDTO msg;
	
	/**
	 * Injection custom messages
	 */
	@Autowired
	private SuggestionService suggestionService;
	
	/**
	 * 
	 * Instance Analyzer methods
	 */
	public QuestionAnalyzerMSG() {
		qaf = new QuestionAnalyzerFinal();
	}

	/**
	 * 
	 * @param description
	 * @return
	 */
	public MsgDTO msgObjective(String description) {
		messages = new ArrayList<>();
		msg = new MsgDTO();
		
		if (qaf.analyzerObjective(description) == 0) {
			msg.setHeader(suggestionService.findByTipo(TSuggestions.IS_OBJECTIVE).getMsg());

			if (qaf.analyzerShortDescriptionQuestion(description) == 0)
				messages.add(suggestionService.findByTipo(TSuggestions.SHOT_DESCRIPTION).getMsg());

			if (!qaf.isQuestionUnique(description))
				messages.add(suggestionService.findByTipo(TSuggestions.UNIQUE_QUESTION).getMsg());
		}

		msg.setSubHeaders(messages);
		return msg;
	}

	/**
	 * 
	 * @param title
	 * @param description
	 * @return
	 */
	public MsgDTO msgClarity(String title, String description) {
		messages = new ArrayList<>();
		msg = new MsgDTO();
		
		if (qaf.analyzerClarity(title, description) == 0) {
			msg.setHeader(suggestionService.findByTipo(TSuggestions.IS_CLARITY).getMsg());

			if (qaf.analyzerObjective(description) == 0)
				messages.add(suggestionService.findByTipo(TSuggestions.IS_OBJECTIVE).getMsg());

			if (qaf.analyzerCoherencyBodyAndTitle(title, description) == 0)
				messages.add(suggestionService.findByTipo(TSuggestions.COERENCY_BODY_WITH_TITLE).getMsg());

			if (!qaf.isQuestionUnique(description))
				messages.add(suggestionService.findByTipo(TSuggestions.EVIDENT_QUESTION).getMsg());
		}

		msg.setSubHeaders(messages);
		return msg;
	}

	/**
	 * 
	 * @param title
	 * @param description
	 * @return
	 */
	public MsgDTO msgUnderstandableDescription(String title, String description) {
		messages = new ArrayList<>();
		msg = new MsgDTO();
		
		if (qaf.analyzerUnderstandableDescription(title, description) == 0) {
			msg.setHeader(suggestionService.findByTipo(TSuggestions.UNDESTANDABLE_DESCRTION).getMsg());

			if (qaf.analyzerObjective(description) == 0)
				messages.add(suggestionService.findByTipo(TSuggestions.IS_OBJECTIVE).getMsg());

			if (qaf.analyzerClarity(title, description) == 0)
				messages.add(suggestionService.findByTipo(TSuggestions.IS_CLARITY).getMsg());
			
			if (qaf.analyzerShowExample(description) == 0) {
				msg.setHeader(suggestionService.findByTipo(TSuggestions.SHOW_EXAMPLE).getMsg());
			}
			
			if(qaf.avoidingMuchCode(description) == 0) {
				msg.setHeader(suggestionService.findByTipo(TSuggestions.IS_OBJECTIVE_MUCH_CODE).getMsg());
			}
			
			if(qaf.containsURL(description) == 1) {
				if(qaf.combinateURLWithContent(description) == 0) {
					msg.setHeader(suggestionService.findByTipo(TSuggestions.COMBINATE_URL).getMsg());					
				}
			}
		}

		msg.setSubHeaders(messages);
		return msg;
	}

	/**
	 * 
	 * @param description
	 * @return
	 */
	public MsgDTO msgBeEducated(String description) {
		messages = new ArrayList<>();
		msg = new MsgDTO();
		
		if (qaf.analyzerBeEducated(description) == 0) {
			msg.setHeader(suggestionService.findByTipo(TSuggestions.BE_EDUCADED).getMsg());

			if (qaf.analyzerUsingProperLanguage(description) == 0)
				messages.add(suggestionService.findByTipo(TSuggestions.USING_PROPER_LANGUAGE).getMsg());

			if (qaf.includingGreetings(description) == 0)
				messages.add(suggestionService.findByTipo(TSuggestions.GREAT).getMsg());
			
			if (qaf.analyzerDoNotCreateHomeworkQuestions(description) == 0) {
				msg.setHeader(suggestionService.findByTipo(TSuggestions.HOME_WORK_QUESTION).getMsg());
			}
		}

		msg.setSubHeaders(messages);
		return msg;
	}
}
