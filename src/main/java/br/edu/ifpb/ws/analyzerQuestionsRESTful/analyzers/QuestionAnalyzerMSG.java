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
				messages.add(suggestionService.findByTipo(TSuggestions.IS_OBJECIVE_DC).getMsg());

			if (!qaf.isQuestionUnique(description))
				messages.add(suggestionService.findByTipo(TSuggestions.IS_OBJECTIVE_QUESTION_UNIQUE).getMsg());

			if (qaf.avoidingMuchCode(description) == 0)
				messages.add(suggestionService.findByTipo(TSuggestions.IS_OBJECTIVE_MUCH_CODE).getMsg());
		}

		msg.setSubHeaders(messages);
		return msg;
	}

	/**
	 * 
	 * @param description
	 * @return
	 */
	public MsgDTO msgExample(String description) {
		msg = new MsgDTO();
		
		if (qaf.analyzerShowExample(description) == 0) {
			msg.setHeader(suggestionService.findByTipo(TSuggestions.SHOW_EXAMPLE).getMsg());
		}
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

			if (qaf.analyzerShowExample(description) == 0)
				messages.add(suggestionService.findByTipo(TSuggestions.SHOW_EXAMPLE).getMsg());

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
	public MsgDTO msgUnderstandableDescription(String title, String description) {
		messages = new ArrayList<>();
		msg = new MsgDTO();
		
		if (qaf.analyzerUnderstandableDescription(title, description) == 0) {
			msg.setHeader(suggestionService.findByTipo(TSuggestions.UNDESTANDABLE_DESCRTION).getMsg());

			if (qaf.analyzerObjective(description) == 0)
				messages.add(suggestionService.findByTipo(TSuggestions.IS_OBJECTIVE).getMsg());

			if (qaf.analyzerClarity(title, description) == 0)
				messages.add(suggestionService.findByTipo(TSuggestions.IS_CLARITY).getMsg());
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
	public MsgDTO msgCoherencyBodyAndTitle(String title, String description) {
		msg = new MsgDTO();
		if (qaf.analyzerCoherencyBodyAndTitle(title, description) == 0) {
			msg.setHeader(suggestionService.findByTipo(TSuggestions.COERENCY_BODY_WITH_TITLE).getMsg());
		}

		return msg;
	}
	
	/**
	 * 
	 * @param description
	 * @return
	 */
	public MsgDTO msgUsingProperLanguage(String description) {
		msg = new MsgDTO();
		if (qaf.analyzerUsingProperLanguage(description) == 0) {
			msg.setHeader(suggestionService.findByTipo(TSuggestions.USING_PROPER_LANGUAGE).getMsg());
		}

		return msg;
	}

	/**
	 * 
	 * @param title
	 * @param description
	 * @return
	 */
	public MsgDTO msgUnderstandableTitle(String title, String description) {
		messages = new ArrayList<>();
		msg = new MsgDTO();
		
		if (qaf.analyzerUnderstandableTitle(title, description) == 0) {
			msg.setHeader(suggestionService.findByTipo(TSuggestions.TITLE_WELL_DEFINED).getMsg());
			if (!qaf.isMediumSizeTitle(title))
				messages.add(suggestionService.findByTipo(TSuggestions.TITLE_MEDIO).getMsg());

			if (qaf.analyzerCoherencyBodyAndTitle(title, description) == 0)
				messages.add(suggestionService.findByTipo(TSuggestions.COERENCY_BODY_WITH_TITLE).getMsg());
		}

		msg.setSubHeaders(messages);
		return msg;
	}
	
	/**
	 * 
	 * @param description
	 * @return
	 */
	public MsgDTO msgShortDescriptionQuestion(String description) {
		msg = new MsgDTO();
		
		if (qaf.analyzerShortDescriptionQuestion(description) == 0) {
			msg.setHeader(suggestionService.findByTipo(TSuggestions.SHORT_DESCRIPTION).getMsg());
		}

		return msg;
	}

	/**
	 * 
	 * @param description
	 * @return
	 */
	public MsgDTO msgDoNotCreateHomeworkQuestions(String description) {
		msg = new MsgDTO();
		
		if (qaf.analyzerDoNotCreateHomeworkQuestions(description) == 0) {
			msg.setHeader(suggestionService.findByTipo(TSuggestions.HOME_WORK_QUESTION).getMsg());
		}

		return msg;
	}
}
