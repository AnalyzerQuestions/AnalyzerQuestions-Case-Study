aqtApp.factory('resourceQuestionService', function($resource) {
	
	return $resource('/questions/:questionId', null, {
		update : {
			method: 'PUT'
		}
	});
})
aqtApp.service('questionService', function(resourceQuestionService){
	
	var optionsQuestionsClicked = [];
	
	this.getOptionsQuestionsClicked = function(user){
		generateOptionsClicked();
		return optionsQuestionsClicked;
	};
	
	this.getById = function(questionId){
		return resourceQuestionService.get({questionId: questionId});
	};
	
	this.updateQuestion = function(question){
		return resourceQuestionService.update(question);
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