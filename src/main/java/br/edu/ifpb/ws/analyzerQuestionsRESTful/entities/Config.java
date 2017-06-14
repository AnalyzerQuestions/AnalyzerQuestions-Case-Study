package br.edu.ifpb.ws.analyzerQuestionsRESTful.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Config {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String time;

	@ElementCollection
	private List<String> optionsQuestionsClicked;

	@ElementCollection
	private List<String> optionsQuestionsChosen;

	@OneToOne(cascade = CascadeType.ALL)
	private StepConfig steps;

	@ElementCollection
	private List<String> suggestions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public StepConfig getSteps() {
		return steps;
	}

	public void setSteps(StepConfig steps) {
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
