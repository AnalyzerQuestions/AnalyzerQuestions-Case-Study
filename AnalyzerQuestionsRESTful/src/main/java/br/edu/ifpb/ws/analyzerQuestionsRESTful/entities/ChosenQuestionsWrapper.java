package br.edu.ifpb.ws.analyzerQuestionsRESTful.entities;

import java.util.List;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>	
 *
 */
public class ChosenQuestionsWrapper {

	private List<Question> clickedQuestions;
	private List<Question> chosenQuestions;

	public List<Question> getClickedQuestions() {
		return clickedQuestions;
	}

	public void setClickedQuestions(List<Question> clickedQuestions) {
		this.clickedQuestions = clickedQuestions;
	}

	public List<Question> getChosenQuestions() {
		return chosenQuestions;
	}

	public void setChosenQuestions(List<Question> chosenQuestions) {
		this.chosenQuestions = chosenQuestions;
	}

	@Override
	public String toString() {
		return "ChosenQuestionsWrapper [clickedQuestions=" + clickedQuestions + ", chosenQuestions=" + chosenQuestions
				+ "]";
	}

}
