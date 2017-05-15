package br.edu.ifpb.ws.analyzerQuestionsRESTful.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.enumerations.QuestionType;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 * @author <a https://github.com/JoseRafael97">Rafael Feitosa</a>
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

	@ElementCollection
	  @CollectionTable(
	        name="motives",
	        joinColumns=@JoinColumn(name="question_id")
	  )
	@Column(name="motive", columnDefinition="TEXT")
	private List<String> motives;

	public Question() {
	}

	public Question(String title, String description, String descritptionHtml, List<String> tags, boolean isAnswered) {
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

	public List<String> getMotives() {
		return motives;
	}

	public void setMotives(List<String> motives) {
		this.motives = motives;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + ", description=" + description + ", descritptionHtml="
				+ descritptionHtml + ", tags=" + tags + ", answer=" + answer + ", isAnswered=" + isAnswered
				+ ", questionType=" + questionType + ", motives=" + motives + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((descritptionHtml == null) ? 0 : descritptionHtml.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isAnswered ? 1231 : 1237);
		result = prime * result + ((motives == null) ? 0 : motives.hashCode());
		result = prime * result + ((questionType == null) ? 0 : questionType.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (descritptionHtml == null) {
			if (other.descritptionHtml != null)
				return false;
		} else if (!descritptionHtml.equals(other.descritptionHtml))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isAnswered != other.isAnswered)
			return false;
		if (motives == null) {
			if (other.motives != null)
				return false;
		} else if (!motives.equals(other.motives))
			return false;
		if (questionType != other.questionType)
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}
