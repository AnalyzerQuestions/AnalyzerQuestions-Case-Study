aqtApp.service('aqtConfig', function($http) {

	this.getConfig = function() {
		return $http.get('config.json');
	};

	this.updateTime = function(config) {
		return $http.post('/admin/config', config);
	};

	this.getSuggestions = function() {
		return $http.get('/admin/suggestions');
	};

	this.saveSuggestion = function(suggestion) {
		return $http.post('/admin/suggestions', suggestion)
	};
	
	this.updateSuggestion = function(suggestion) {
		return $http.put('/admin/suggestions', suggestion)
	};
	
	this.removeAllSuggestions = function() {
		return $http.delete('/admin/suggestions');
	};

	this.generateSuggestions = function() {

		suggestions = [ 
		               
			sug = {
//				msg : 'Descreva seu problema de forma simples e direta.',
				msg : 'Describe your problem in a way simple and direct.',
				tipo : 'IS_OBJECTIVE',
				categoria :['Objetividade']
	
			}, sug = {
//				msg : 'Descrição curta.',
				msg : 'Short description',
				tipo : 'IS_OBJECIVE_DC',
				categoria : ['Descrição curta']
	
			}, sug = {
//				msg : 'Resuma a pergunta a um único problema.',
				msg : 'Summarize the question in a single problem.',
				tipo : 'IS_OBJECTIVE_QUESTION_UNIQUE',
				categoria : ['Pergunta única']
	
			}, sug = {
//			  msg : 'Evite pergunta com muito código.',
			  msg : 'Avoid a large amount of code',
			  tipo : 'IS_OBJECTIVE_MUCH_CODE',
			  categoria : ['Muito código']
			
			}, sug = {
//			  msg : 'Seja Objetivo e deixe a pergunta mais evidente possível.',
			  msg : 'Be objective and let the question most evident.',
			  tipo : 'IS_CLARITY',
			  categoria : ['Clara']
				  
			}, sug = {
//			  msg : 'Resuma a pergunta a um único problema e/ou deixe mais evidente seu prblema.',
			  msg : 'Summarize the question in a single problem and/or let question most evident.',
			  tipo : 'UNIQUE_QUESTION',
			  categoria : ['Pergunta única']
				  
			}, sug = {
//			  msg : 'Use a norma culta da língua.',
			  msg : 'Use proper language.',
			  tipo : 'USING_PROPER_LANGUAGE',
			  categoria : ['Uso da língua']
					  
			}, sug = {
//			  msg : 'Adicione algum tipo de agradecimento ao final de sua pergunta.',
			  msg : 'Add some kind of thanks at the end of the question.',
			  tipo : 'GREAT',
			  categoria : ['Agradecimento']
				  
			}, sug = {
//			  msg : 'Evite criar o título da pergunta muito longo ou curto.',
			  msg : 'Avoid creating a question with large or too much short title.',
			  tipo : 'TITLE_MEDIO',
			  categoria : ['Tamanho do título']
				 
			}, sug = {
//			  msg : 'Adicione um trecho de código ou outro de tipo de exemplo na pergunta.',
			  msg : 'Add a snippet of code or another kind of example.',
			  tipo : 'SHOW_EXAMPLE',
			  categoria : ['Mostrar exemplo']
				  
			}, sug = {
//			  msg : 'Seja educado, use a norma culta da língua e adicione algum tipo de agradecimento.',
			  msg : 'Be polite, use proper language and add a greeting.',
			  tipo : 'BE_EDUCADED',
			  categoria : ['Ser educado']
			
			}, sug = {
//			  msg : 'Evite criar perguntas sobre trabalhos acadêmicos.',
			  msg : 'Avoid creating homework question.',
			  tipo : 'HOME_WORK_QUESTION',
			  categoria : ['Perguntas acadêmicas']
			
			}, sug = {
//			  msg : 'Evite adicionar muita informação na descrição da pergunta, seja sucinto.',
			  msg : 'Avoid long description, be objective.',
			  tipo : 'SHORT_DESCRIPTION',
			  categoria : ['Descrição curta']
			
			}, sug = {
//			  msg : 'Seja mais objetivo e claro na formulação da pergunta.',
			  msg : 'Be more objective and course on the question',
			  tipo : 'UNDESTANDABLE_DESCRTION',
			  categoria : ['Descrição bem definida']
				  
			}, sug = {
//			  msg : 'Descreva melhor o título da pergunta, o título deve ser o resumo da descrição do problema.',
			  msg : "Improve the title of the question, it's should be a summarize to the description of the problem.",
			  tipo : 'TITLE_WELL_DEFINED',
			  categoria : ['Título bem definido']
				  
			}, sug = {
//			  msg : 'O Título da pergunta parece não está coerente com a descrição.',
			  msg : 'The title of the question is not consistent with the description.',
			  tipo : 'COERENCY_BODY_WITH_TITLE',
			  categoria : ['Coerência']
			}
		];
		
		return suggestions;
	};

});