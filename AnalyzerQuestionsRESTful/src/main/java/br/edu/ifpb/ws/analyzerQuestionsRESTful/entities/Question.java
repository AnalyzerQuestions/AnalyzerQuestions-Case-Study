package br.edu.ifpb.ws.analyzerQuestionsRESTful.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.enumerations.QuestionType;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Entity
@Table(name = "QUESTION")
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String title;

	@Column(columnDefinition = "TEXT")
	private String description;

	@Column(name = "descrition_html", columnDefinition = "TEXT")
	private String descritptionHtml;

	@ElementCollection
	private List<String> tags;

	private String answer;
	private boolean isAnswered;

	@Enumerated(EnumType.STRING)
	private QuestionType questionType;

	public Question() {
	}
	
	public Question(String title, String description, String descritptionHtml, 
							List<String> tags, boolean isAnswered) {
		this.title = title;
		this.description = description;
		this.descritptionHtml = descritptionHtml;
		this.tags = tags;
		this.isAnswered = isAnswered;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescritptionHtml() {
		return descritptionHtml;
	}

	public boolean isAnswered() {
		return isAnswered;
	}

	public void setAnswered(boolean isAnswered) {
		this.isAnswered = isAnswered;
	}

	public void setDescritptionHtml(String descritptionHtml) {
		this.descritptionHtml = descritptionHtml;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + ", description=" + description + ", descritptionHtml="
				+ descritptionHtml + ", tags=" + tags + ", answer=" + answer + ", questionType=" + questionType + "]";
	}

}
