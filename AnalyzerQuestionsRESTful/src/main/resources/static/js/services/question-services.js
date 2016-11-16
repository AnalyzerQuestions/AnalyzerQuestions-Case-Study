aqtApp.service('questionService', function(resourceService){
	
	var optionsQuestionsClicked = [];
	
	this.getOptionsQuestionsClicked = function(user){
		generateOptionsClicked();
		return optionsQuestionsClicked;
	};
	
	
	var generateOptionsClicked = function(){
		
		optionsQuestionsClicked = [
		                           'Muito curta, pouco clara, vaga ou difícil de entender.',
		                           'Programa específico sem um trecho de código ou explicação adequada.',
		                           'Muito difícil, muito específica ou muito extensa.',
		                           'Problema de uma tecnologia proprietária.',
		                           'Não é uma pergunta de programação.',
		                           'Já possui a resposta na pergunta.',
		                           'Resposta não é relevante ou necessária.',
		                           'Pergunta de trabalhos acadêmicos.'
	    ]
	};
});