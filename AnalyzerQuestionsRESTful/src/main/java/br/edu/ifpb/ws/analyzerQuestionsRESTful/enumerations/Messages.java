package br.edu.ifpb.ws.analyzerQuestionsRESTful.enumerations;

public enum Messages {
	
	TITULO_BEM_DEFINIDO("Descreva melhor o título da pergunta."),
	MEDIO_SIZE_TITLE("Evite título curto ou grande demais."),
	TITLE_CAPITA_LETTERS("O título poderia está em caixa alta."), 
	TITLE_CAPITA_PARTIALLY_LETTERS("O título poderia está parcialmente em caixa alta."), 
	COERENCY_BODY_WITH_TITLE("O Título parece não está coerente com a descrição."), 
	UNDERSTANDABLE_DESCRIPTION("Descreva melhor a descrição da pergunta."), 
	INCLUDING_VOCATIVE("Você poderia iniciar a descrição com um vocativo por exemplo: Pessoal, ... "), 
	SHOW_EXAMPLE("Adicione um exemplo na sua descrição, isso irá ajudar no entedimento da pergunta."), 
	SHORT_DESCRIPTION("Evite descrição muito curta."), 
	LONG_DESCRIPTION("Evite descrição muito longa."), 
	AVOIDING_MUCH_CODE("Evite descrição com muito código."), 
	AVOIDING_DESCRIPTION_WITH_CODE_ONLY("Evite adicionar apenas código na descrição da pergunta."), 
	QUESTION_WITH_SINGLE_PROBLEM("Restrinja seu problema a apenas um único problema."), 
	INCLUDING_GREETINGS("É aconselhável adicionar algum agradecimento na descrição da pergunta.");
	
	
	
	private String msg;
	
	
	private Messages(String msg) {
		this.msg= msg;
	}

	public String getMsg() {
		return msg;
	}
	
	

}
