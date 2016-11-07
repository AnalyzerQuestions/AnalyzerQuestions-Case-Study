package br.edu.ifpb.ws.analyzerQuestionsRESTful.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="question_mod_sugg")
public class QuestionWrapper {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Question question;
	
	@ElementCollection
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
