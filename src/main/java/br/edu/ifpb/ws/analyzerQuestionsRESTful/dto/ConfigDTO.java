package br.edu.ifpb.ws.analyzerQuestionsRESTful.dto;

import java.util.List;

public class ConfigDTO {

	private String time;
	private List<String> optionsQuestionsClicked;
	private List<String> optionsQuestionsChosen;
	private StepDTO steps;
	private List<String> suggestions;

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

	public StepDTO getSteps() {
		return steps;
	}

	public void setSteps(StepDTO steps) {
		this.steps = steps;
	}

	public List<String> getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(List<String> suggestions) {
		this.suggestions = suggestions;
	}

	@Override
	public String toString() {
		return "Config [time=" + time + ", optionsQuestionsClicked=" + optionsQuestionsClicked
				+ ", optionsQuestionsChosen=" + optionsQuestionsChosen + "]";
	}

}
