package br.edu.ifpb.ws.analyzerQuestionsRESTful.enumerations;

public enum Messages {
	
	TITULO_BEM_DEFINIDO("Descreva melhor o título da pergunta."),
	
	COERENCY_BODY_WITH_TITLE("O Título da pergunta parece não está coerente com a descrição."),
	
	IS_OBJECTIVE("Descreva seu problema de forma simples e direta."),
	
	IS_CLARITY("Seja Objetivo e deixe a pergunta mais evidente."),
	
	SHOW_EXAMPLE("Adicione um trecho de código ou outro de tipo de exemplo na pergunta."),
	
	DETAIL_CONTEXT("Detalhe mais o problema."),

	USING_PROPER_LANGUAGE("Use a norma culta da língua."),

	BE_EDUCADED("Use a norma culta da língua e adicione algum tipo de agradecimento."),
	
	HOME_WORK_QUESTION("Evite criar perguntas sobre trabalhos acadêmicos."),
	
	SHORT_DESCRIPTION("Evite descrição muito curta."), 

	UNDESTANDABLE_DESCRTION("Seja mais objetivo e claro na formulação da pergunta"); 
	
	
	
	private String msg;
	
	
	private Messages(String msg) {
		this.msg= msg;
	}

	public String getMsg() {
		return msg;
	}
	
	

}
