package br.edu.ifpb.ws.analyzerQuestionsRESTful.analyzers;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.MSG;
import br.edu.ifpb.ws.analyzerQuestionsRESTful.enumerations.Messages;

public class QuestionAnalyzerMSG {

	QuestionAnalyzerFinal qaf;
	List<String> messages;
	MSG msg;

	public QuestionAnalyzerMSG() {
		qaf = new QuestionAnalyzerFinal();
	}

	public MSG msgObjective(String description) {
		messages = new ArrayList<>();
		msg = new MSG();
		if (qaf.analyzerObjective(description) == 0) {
			msg.setHeader(Messages.IS_OBJECTIVE.getMsg());

			if (qaf.analyzerShortDescriptionQuestion(description) == 0)
				messages.add(Messages.IS_OBJECIVE_DC.getMsg());

			if (!qaf.isQuestionUnique(description))
				messages.add(Messages.IS_OBJECTIVE_QUESTION_UNIQUE.getMsg());

			if (qaf.avoidingMuchCode(description) == 0)
				messages.add(Messages.IS_OBJECTIVE_MUCH_CODE.getMsg());
		}

		msg.setMessages(messages);
		return msg;
	}

	public MSG msgExample(String description) {
		msg = new MSG();
		if (qaf.analyzerShowExample(description) == 0) {
			msg.setHeader(Messages.SHOW_EXAMPLE.getMsg());
		}
		return msg;
	}

	public MSG msgClarity(String title, String description) {
		messages = new ArrayList<>();
		msg = new MSG();
		if (qaf.analyzerClarity(title, description) == 0) {
			msg.setHeader(Messages.IS_CLARITY.getMsg());

			if (qaf.analyzerObjective(description) == 0)
				messages.add("Seja mais objetivo.");

			if (qaf.analyzerCoherencyBodyAndTitle(title, description) == 0)
				messages.add("O Título da pergunta parece não está coerente com a descrição.");

			if (qaf.analyzerShowExample(description) == 0)
				messages.add("Adicione um trecho de código ou outro de tipo de exemplo na pergunta.");

			if (!qaf.isQuestionUnique(description))
				messages.add("Resuma a pergunta a um único problema e/ou deixe mais evidente seu prblema.");
		}

		msg.setMessages(messages);
		return msg;
	}

	public MSG msgUnderstandableDescription(String title, String description) {
		messages = new ArrayList<>();
		msg = new MSG();
		if (qaf.analyzerUnderstandableDescription(title, description) == 0) {
			msg.setHeader(Messages.UNDESTANDABLE_DESCRTION.getMsg());

			if (qaf.analyzerObjective(description) == 0)
				messages.add("Seja mais objetivo.");

			if (qaf.analyzerClarity(title, description) == 0)
				messages.add("Seja mais Claro.");
		}

		msg.setMessages(messages);
		return msg;
	}

	public MSG msgBeEducated(String description) {
		messages = new ArrayList<>();
		msg = new MSG();
		if (qaf.analyzerBeEducated(description) == 0) {
			msg.setHeader(Messages.BE_EDUCADED.getMsg());

			if (qaf.analyzerUsingProperLanguage(description) == 0)
				messages.add("Use a norma culta da língua.");

			if (qaf.includingGreetings(description) == 0)
				messages.add("adicione algum tipo de agradecimento.");
		}

		msg.setMessages(messages);
		return msg;
	}

	public MSG msgCoherencyBodyAndTitle(String title, String description) {
		msg = new MSG();
		if (qaf.analyzerCoherencyBodyAndTitle(title, description) == 0) {
			msg.setHeader(Messages.COERENCY_BODY_WITH_TITLE.getMsg());
		}

		return msg;
	}

	public MSG msgUsingProperLanguage(String description) {
		msg = new MSG();
		if (qaf.analyzerUsingProperLanguage(description) == 0) {
			msg.setHeader(Messages.USING_PROPER_LANGUAGE.getMsg());
		}

		return msg;
	}

	public MSG msgUnderstandableTitle(String title, String description) {
		messages = new ArrayList<>();
		msg = new MSG();
		if (qaf.analyzerUnderstandableTitle(title, description) == 0) {
			msg.setHeader(Messages.TITULO_BEM_DEFINIDO.getMsg());
			if (!qaf.isMediumSizeTitle(title))
				messages.add("Evite escrever titulo muito curto ou muito longo.");

			if (qaf.analyzerCoherencyBodyAndTitle(title, description) == 0)
				messages.add("O Título da pergunta parece não está coerente com a descrição.");
		}

		msg.setMessages(messages);
		return msg;
	}

	public MSG msgShortDescriptionQuestion(String description) {
		msg = new MSG();
		if (qaf.analyzerShortDescriptionQuestion(description) == 0) {
			msg.setHeader(Messages.SHORT_DESCRIPTION.getMsg());
		}

		return msg;
	}

	public MSG msgDoNotCreateHomeworkQuestions(String description) {
		msg = new MSG();
		if (qaf.analyzerDoNotCreateHomeworkQuestions(description) == 0) {
			msg.setHeader(Messages.HOME_WORK_QUESTION.getMsg());
		}

		return msg;
	}
	
}
