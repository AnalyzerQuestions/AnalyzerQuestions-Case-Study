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

/**
 * 
 * <p>
 * <b> Question Wrapper</b>
 * </p>
 *
 * <p>
 * Class wrapper for questions with suggestions chosen in step 1.
 * </p>
 * 
 * <pre>
 * &#64;see <a href="http://www.linkreferencia.com">Link de Referencia</a>
 * </pre>
 * 
 *
 */
@Entity
@Table(name = "QUESTION_CHANGE_WITH_SUGESTIONS")
public class QuestionWrapper {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	private Question question;

	@ElementCollection
	private List<String> suggestions;

	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private FeedBackSuggestion feedback;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FeedBackSuggestion getFeedback() {
		return feedback;
	}

	public void setFeedback(FeedBackSuggestion feedback) {
		this.feedback = feedback;
	}

}
