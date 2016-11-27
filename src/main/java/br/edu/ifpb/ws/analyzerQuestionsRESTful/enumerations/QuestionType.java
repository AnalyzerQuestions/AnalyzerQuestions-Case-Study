package br.edu.ifpb.ws.analyzerQuestionsRESTful.enumerations;

public enum QuestionType {
	
	ORIGINAL("Original"), CHANGED_WITH_SUGGESTION("Modificada"), CHOSEN("Selecionada"), CLICABLE("Clicada");
	
	private String attr;

	private QuestionType(String attr) {
		this.attr = attr;
	}

	public String getAttr() {
		return attr;
	}


}
