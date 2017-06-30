aqtApp.service('aqtConfig', function($http) {

	this.getConfig = function() {
		return $http.get('/config');
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
		   			msg : 'Seja Objetivo',
//	   				msg : 'Describe your problem in a way simple and direct.',
	   				tipo : 'IS_OBJECTIVE',
	   				categoria :['Objetividade', 'HEADER']
	   	
	   			}, sug = {
		   			msg : 'Evite adicionar muita informação na descrição da pergunta, seja sucinto.',
//	   				msg : 'Short description',
	   				tipo : 'SHOT_DESCRIPTION',
	   				categoria : ['Objetividade']

	   			}, sug = {
	  		   		  msg : 'Resuma a pergunta a um único problema.',
//	  	   			  msg : 'Summarize the question in a single problem and/or let question most evident.',
	  	   			  tipo : 'UNIQUE_QUESTION',
	  	   			  categoria : ['Objetividade']	   	
	   			
	   			}, sug = {
		   		  msg : 'Seja Objetivo e deixe a pergunta mais evidente possível.',
//	   			  msg : 'Be objective and let the question most evident.',
	   			  tipo : 'IS_CLARITY',
	   			  categoria : ['Clareza', 'HEADER']
	   				  
	   			}, sug = {
	  		   		  msg : 'Resuma a pergunta a um único problema e o deixe mais evidente possível.',
	  	   			  tipo : 'EVIDENT_QUESTION',
	  	   			  categoria : ['Clareza']
	   				  
	   			}, sug = {
	  		   		  msg : 'O Título da pergunta parece não está coerente com a descrição.',
//	  	   			  msg : 'The title of the question is not consistent with the description.',
	  	   			  tipo : 'COERENCY_BODY_WITH_TITLE',
	  	   			  categoria : ['Clareza']
	   			
	   			}, sug = {
	  		   		  msg : 'Seja educado',
//	  	   			  msg : 'Be polite, use proper language and add a greeting.',
	  	   			  tipo : 'BE_EDUCADED',
	  	   			  categoria : ['Ser educado', 'HEADER']	   			
	   			
	   			}, sug = {
		   		  msg : 'Use a norma culta da língua.',
//	   			  msg : 'Use proper language.',
	   			  tipo : 'USING_PROPER_LANGUAGE',
	   			  categoria : ['Ser educado']
	   					  
	   			}, sug = {
		   	      msg : 'Adicione algum tipo de agradecimento ao final de sua pergunta.',
//	   			  msg : 'Add some kind of thanks at the end of the question.',
	   			  tipo : 'GREAT',
	   			  categoria : ['Ser educado']
	   			
	   			}, sug = {
	  		   		  msg : 'Evite criar perguntas sobre trabalhos acadêmicos.',
//	  	   			  msg : 'Avoid creating homework question.',
	  	   			  tipo : 'HOME_WORK_QUESTION',
	  	   			  categoria : ['Ser educado']	   			
	   				 
	   			}, sug = {
	  		    	  msg : 'Seja mais objetivo e claro na formulação da pergunta.',
//	  	   			  msg : 'Be more objective and course on the question',
	  	   			  tipo : 'UNDESTANDABLE_DESCRTION',
	  	   			  categoria : ['Descrição bem definida', 'HEADER']	   			
	   			
	   			}, sug = {
		   		  msg : 'Adicione um trecho de código ou outro de tipo de exemplo na pergunta.',
//	   			  msg : 'Add a snippet of code or another kind of example.',
	   			  tipo : 'SHOW_EXAMPLE',
	   			  categoria : ['Descrição bem definida']
	   			
	   			}, sug = {
	  		   		  msg : 'Evite adicionar links a pergunta sem especificar o seu conteúdo.',
	  	   			  tipo : 'COMBINATE_URL',
	  	   			  categoria : ['Descrição bem definida']	   			
	   				  
	   			}, sug = {
	  		    	  msg : 'Evite adicionar muito código a pergunta.',
	  	   			  tipo : 'IS_OBJECTIVE_MUCH_CODE',
	  	   			  categoria : ['Descrição bem definida']	   			
	   				  
	   			}
	   		];

		return suggestions;
	};
});