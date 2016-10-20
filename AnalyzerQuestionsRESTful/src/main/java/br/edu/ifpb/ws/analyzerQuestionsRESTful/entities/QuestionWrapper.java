package br.edu.ifpb.ws.analyzerQuestionsRESTful.entities;

import java.util.List;

public class QuestionWrapper {

	private Question question;
	private List<String> suggestions;

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<String> getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(List<String> suggestions) {
		this.suggestions = suggestions;
	}

	@Override
	public String toString() {
		return "QuestionWrapper [question=" + question + ", suggestions=" + suggestions + "]";
	}

}
