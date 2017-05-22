package br.edu.ifpb.ws.analyzerQuestionsRESTful.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 *
 */
@Entity
@Table(name = "feedback_suggestion")
public class FeedBackSuggestion {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	/**
	 * 
	 */
	@Column(name = "is_important")
	private boolean important;

	/**
	 * 
	 */
	@Column(columnDefinition = "TEXT")
	private String justification;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isImportant() {
		return important;
	}

	public void setImportant(boolean important) {
		this.important = important;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

}
