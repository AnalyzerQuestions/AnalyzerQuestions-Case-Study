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

	this.generateSuggestions = function() {

		suggestions = [ 
		               
			sug = {
				msg : 'Descreva seu problema de forma simples e direta.',
				tipo : 'IS_OBJECTIVE'
	
			}, sug = {
				msg : 'Descrição curta.',
				tipo : 'IS_OBJECIVE_DC'
	
			}, sug = {
				msg : 'Resuma a pergunta a um único problema.',
				tipo : 'IS_OBJECTIVE_QUESTION_UNIQUE'
	
			}, sug = {
			  msg : 'Evite pergunta com muito código.',
			  tipo : 'IS_OBJECTIVE_MUCH_CODE'
			
			}, sug = {
			  msg : 'Seja Objetivo e deixe a pergunta mais evidente.',
			  tipo : 'IS_CLARITY'
				  
			}, sug = {
			  msg : 'Descreva seu problema de forma simples e direta.',
			  tipo : 'IS_CLARITY_OBJECTIVE'
				  
			}, sug = {
			  msg : 'Resuma a pergunta a um único problema e/ou deixe mais evidente seu prblema.',
			  tipo : 'UNIQUE_QUESTION'
				  
			}, sug = {
			  msg : 'Use a norma culta da língua.',
			  tipo : 'USING_PROPER_LANGUAGE'
					  
			}, sug = {
			  msg : 'Adicione algum tipo de agradecimento.',
			  tipo : 'GREAT'
				  
			}, sug = {
			  msg : 'Título longo ou curto.',
			  tipo : 'TITLE_MEDIO'
				 
			}, sug = {
			  msg : 'Adicione um trecho de código ou outro de tipo de exemplo na pergunta.',
			  tipo : 'SHOW_EXAMPLE'
				  
			}, sug = {
			  msg : 'Detalhe mais o problema.',
			  tipo : 'DETAIL_CONTEXT'
				  
			}, sug = {
			  msg : 'Seja educado, adione algum tipo de gratificação.',
			  tipo : 'BE_EDUCADED'
			
			}, sug = {
			  msg : 'Evite criar perguntas sobre trabalhos acadêmicos.',
			  tipo : 'HOME_WORK_QUESTION'
			
			}, sug = {
			  msg : 'Evite descrição muito curta.',
			  tipo : 'SHORT_DESCRIPTION'
			
			}, sug = {
			  msg : 'Seja mais objetivo e claro na formulação da pergunta.',
			  tipo : 'UNDESTANDABLE_DESCRTION'
				  
			}, sug = {
			  msg : 'Descreva melhor o título da pergunta.',
			  tipo : 'TITULO_BEM_DEFINIDO'
				  
			}, sug = {
			  msg : 'O Título da pergunta parece não está coerente com a descrição.',
			  tipo : 'COERENCY_BODY_WITH_TITLE'
			}
		];
		
		return suggestions;
	};

});