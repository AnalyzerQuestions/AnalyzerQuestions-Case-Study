package br.edu.ifpb.ws.analyzerQuestionsRESTful.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>	
 *
 */
@Entity
@Table(name="CHOSEN_QUESTIONS")
public class ChosenQuestionsWrapper {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
	private List<Question> clickedQuestions;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},  orphanRemoval = true)
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
		return "ChosenQuestionsWrapper [clickedQuestions=" + clickedQuestions + ", chosenQuestions=" + chosenQuestions + "]";
	}

}
