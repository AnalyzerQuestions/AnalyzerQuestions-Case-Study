package br.edu.ifpb.ws.analyzerQuestionsRESTful.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * <p>
 * 		<b> User </b>
 * </p>
 *
 * <p>
 * class of user respondent
 * </p>
 * 
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 * @author <a https://github.com/JoseRafael97">Rafael Feitosa</a>
 *
 */
@Entity
@Table(name="USUARIO")
public class Usuario {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	private String name;
	
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date accessDate = new Date();
	
	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private QuestionWrapper questionWrapper;
	
	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private ChosenQuestionsWrapper chosenQuestionsWrapper;
	
	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private Question question;
	
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Date getAccessDate() {
		return accessDate;
	}

	public QuestionWrapper getQuestionWrapper() {
		return questionWrapper;
	}

	public ChosenQuestionsWrapper getChosenQuestionsWrapper() {
		return chosenQuestionsWrapper;
	}

	public void setAccessDate(Date accessDate) {
		this.accessDate = accessDate;
	}

	public void setQuestionWrapper(QuestionWrapper questionWrapper) {
		this.questionWrapper = questionWrapper;
	}

	public void setChosenQuestionsWrapper(ChosenQuestionsWrapper chosenQuestionsWrapper) {
		this.chosenQuestionsWrapper = chosenQuestionsWrapper;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", accessDate=" + accessDate
				+ ", questionWrapper=" + questionWrapper + ", chosenQuestionsWrapper=" + chosenQuestionsWrapper
				+ ", question=" + question + "]";
	}

}
