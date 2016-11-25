aqtApp.service('aqtConfig', function($http) {

	this.getConfig = function() {
		return $http.get('config.json');
	};

	this.updateTime = function(config) {
		return $http.post('/config', config);
	};

	this.getSuggestions = function() {
		return $http.get('/suggestions');
	};

	this.saveSuggestion = function(suggestion) {
		return $http.post('/suggestions', suggestion)
	};
	
	this.updateSuggestion = function(suggestion) {
		return $http.put('/suggestions', suggestion)
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
			  msg : 'Seja Objetivo e deixe a pergunta mais evidente.',
			  tipo : 'IS_CLARITY',
			  categoria : ['Clara']
				  
			}, sug = {
			  msg : 'Descreva seu problema de forma simples e direta.',
			  tipo : 'IS_CLARITY_OBJECTIVE',
			  categoria : ['Objetividade']
				  
			}, sug = {
			  msg : 'Resuma a pergunta a um único problema e/ou deixe mais evidente seu prblema.',
			  tipo : 'UNIQUE_QUESTION',
			  categoria : ['Pergunta única']
				  
			}, sug = {
			  msg : 'Use a norma culta da língua.',
			  tipo : 'USING_PROPER_LANGUAGE',
			  categoria : ['Uso da língua']
					  
			}, sug = {
			  msg : 'Adicione algum tipo de agradecimento.',
			  tipo : 'GREAT',
			  categoria : ['Agradecimento']
				  
			}, sug = {
			  msg : 'Título longo ou curto.',
			  tipo : 'TITLE_MEDIO',
			  categoria : ['Tamanho do título']
				 
			}, sug = {
			  msg : 'Adicione um trecho de código ou outro de tipo de exemplo na pergunta.',
			  tipo : 'SHOW_EXAMPLE',
			  categoria : ['Mostrar exemplo']
				  
			}, sug = {
			  msg : 'Seja educado, adione algum tipo de gratificação.',
			  tipo : 'BE_EDUCADED',
			  categoria : ['Ser educado']
			
			}, sug = {
			  msg : 'Evite criar perguntas sobre trabalhos acadêmicos.',
			  tipo : 'HOME_WORK_QUESTION',
			  categoria : ['Perguntas acadêmicas']
			
			}, sug = {
			  msg : 'Evite descrição muito curta.',
			  tipo : 'SHORT_DESCRIPTION',
			  categoria : ['Descrição curta']
			
			}, sug = {
			  msg : 'Seja mais objetivo e claro na formulação da pergunta.',
			  tipo : 'UNDESTANDABLE_DESCRTION',
			  categoria : ['Descrição bem definida']
				  
			}, sug = {
			  msg : 'Descreva melhor o título da pergunta.',
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