package br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.pojos;

import java.util.List;

public class Config {

	private String time;
	private List<String> optionsQuestionsClicked;
	private List<String> optionsQuestionsChosen;
	private Step steps;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<String> getOptionsQuestionsClicked() {
		return optionsQuestionsClicked;
	}

	public void setOptionsQuestionsClicked(List<String> optionsQuestionsClicked) {
		this.optionsQuestionsClicked = optionsQuestionsClicked;
	}

	public List<String> getOptionsQuestionsChosen() {
		return optionsQuestionsChosen;
	}

	public void setOptionsQuestionsChosen(List<String> optionsQuestionsChosen) {
		this.optionsQuestionsChosen = optionsQuestionsChosen;
	}

	public Step getSteps() {
		return steps;
	}

	public void setSteps(Step steps) {
		this.steps = steps;
	}

	@Override
	public String toString() {
		return "Config [time=" + time + ", optionsQuestionsClicked=" + optionsQuestionsClicked
				+ ", optionsQuestionsChosen=" + optionsQuestionsChosen + "]";
	}

}
