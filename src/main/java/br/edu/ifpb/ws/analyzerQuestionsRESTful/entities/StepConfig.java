package br.edu.ifpb.ws.analyzerQuestionsRESTful.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "step_config")
public class StepConfig {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long Id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private SubStepConfig welcome;
	
	@OneToOne(cascade = CascadeType.ALL)
	private SubStepConfig step1;
	
	@OneToOne(cascade = CascadeType.ALL)
	private SubStepConfig step2;
	
	@OneToOne(cascade = CascadeType.ALL)
	private SubStepConfig step3;
	
	@OneToOne(cascade = CascadeType.ALL)
	private SubStepConfig end;

	public SubStepConfig getStep1() {
		return step1;
	}

	public void setStep1(SubStepConfig step1) {
		this.step1 = step1;
	}

	public SubStepConfig getStep2() {
		return step2;
	}

	public void setStep2(SubStepConfig step2) {
		this.step2 = step2;
	}

	public SubStepConfig getStep3() {
		return step3;
	}

	public void setStep3(SubStepConfig step3) {
		this.step3 = step3;
	}

	public SubStepConfig getWelcome() {
		return welcome;
	}

	public void setWelcome(SubStepConfig welcome) {
		this.welcome = welcome;
	}

	public SubStepConfig getEnd() {
		return end;
	}

	public void setEnd(SubStepConfig end) {
		this.end = end;
	}

}
