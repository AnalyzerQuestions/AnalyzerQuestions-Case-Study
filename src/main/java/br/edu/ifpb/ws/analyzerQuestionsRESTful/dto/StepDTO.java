package br.edu.ifpb.ws.analyzerQuestionsRESTful.dto;

public class StepDTO {

	private SubStepDTO welcome;
	private SubStepDTO step1;
	private SubStepDTO step2;
	private SubStepDTO step3;
	private SubStepDTO end;

	public SubStepDTO getStep1() {
		return step1;
	}

	public void setStep1(SubStepDTO step1) {
		this.step1 = step1;
	}

	public SubStepDTO getStep2() {
		return step2;
	}

	public void setStep2(SubStepDTO step2) {
		this.step2 = step2;
	}

	public SubStepDTO getStep3() {
		return step3;
	}

	public void setStep3(SubStepDTO step3) {
		this.step3 = step3;
	}

	public SubStepDTO getWelcome() {
		return welcome;
	}

	public void setWelcome(SubStepDTO welcome) {
		this.welcome = welcome;
	}

	public SubStepDTO getEnd() {
		return end;
	}

	public void setEnd(SubStepDTO end) {
		this.end = end;
	}

}
