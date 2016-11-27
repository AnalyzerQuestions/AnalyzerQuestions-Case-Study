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
				msg : 'Descreva seu problema de forma simples e direta.',
				tipo : 'IS_OBJECTIVE',
				categoria :['Objetividade']
	
			}, sug = {
				msg : 'Descrição curta.',
				tipo : 'IS_OBJECIVE_DC',
				categoria : ['Descrição curta']
	
			}, sug = {
				msg : 'Resuma a pergunta a um único problema.',
				tipo : 'IS_OBJECTIVE_QUESTION_UNIQUE',
				categoria : ['Pergunta única']
	
			}, sug = {
			  msg : 'Evite pergunta com muito código.',
			  tipo : 'IS_OBJECTIVE_MUCH_CODE',
			  categoria : ['Muito código']
			
			}, sug = {
			  msg : 'Seja Objetivo e deixe a pergunta mais evidente possível.',
			  tipo : 'IS_CLARITY',
			  categoria : ['Clara']
				  
			}, sug = {
			  msg : 'Resuma a pergunta a um único problema e/ou deixe mais evidente seu prblema.',
			  tipo : 'UNIQUE_QUESTION',
			  categoria : ['Pergunta única']
				  
			}, sug = {
			  msg : 'Use a norma culta da língua.',
			  tipo : 'USING_PROPER_LANGUAGE',
			  categoria : ['Uso da língua']
					  
			}, sug = {
			  msg : 'Adicione algum tipo de agradecimento ao final de sua pergunta.',
			  tipo : 'GREAT',
			  categoria : ['Agradecimento']
				  
			}, sug = {
			  msg : 'Evite cirar o título da pergunta muito longo ou curto.',
			  tipo : 'TITLE_MEDIO',
			  categoria : ['Tamanho do título']
				 
			}, sug = {
			  msg : 'Adicione um trecho de código ou outro de tipo de exemplo na pergunta.',
			  tipo : 'SHOW_EXAMPLE',
			  categoria : ['Mostrar exemplo']
				  
			}, sug = {
			  msg : 'Seja educado, use a norma culta da língua e adicione algum tipo de agradecimento.',
			  tipo : 'BE_EDUCADED',
			  categoria : ['Ser educado']
			
			}, sug = {
			  msg : 'Evite criar perguntas sobre trabalhos acadêmicos.',
			  tipo : 'HOME_WORK_QUESTION',
			  categoria : ['Perguntas acadêmicas']
			
			}, sug = {
			  msg : 'Evite adicionar muita informação na descrição da pergunta, seja sucinto.',
			  tipo : 'SHORT_DESCRIPTION',
			  categoria : ['Descrição curta']
			
			}, sug = {
			  msg : 'Seja mais objetivo e claro na formulação da pergunta.',
			  tipo : 'UNDESTANDABLE_DESCRTION',
			  categoria : ['Descrição bem definida']
				  
			}, sug = {
			  msg : 'Descreva melhor o título da pergunta, o título deve ser o resumo da descrição do problema.',
			  tipo : 'TITULO_BEM_DEFINIDO',
			  categoria : ['Título bem definido']
				  
			}, sug = {
			  msg : 'O Título da pergunta parece não está coerente com a descrição.',
			  tipo : 'COERENCY_BODY_WITH_TITLE',
			  categoria : ['Coerência']
			}
		];
		
		return suggestions;
	};

});