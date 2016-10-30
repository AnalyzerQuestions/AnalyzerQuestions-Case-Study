/**
 * Controller responsável pela manipulação do fragmento de  página new-question.html
 * 
 * @created by Franck Aragão @date 20-10-16.
 */
aqtApp.controller('newQuestionController', function($scope, $http, $location) {
	
	const URI = 'http://localhost:8080';
	var chosenSuggestions = [];
	var buttonGetSug = $('#btn-get-sug');
	var buttonCompletter = $('#btn-completter');
	$scope.suggestions = [];

	/**
	 * Submete uma nova pergunta à API e obtem sugestões.
	 */
	$scope.getSuggestions = function(question) {
		
		question.markdownDescription = post = $('#editor-f').data('markdown').parseContent();
	    
		$http({
			method : 'POST',
			url : URI+'/analyzer',
			data : question,

		}).then(function onSucces(response) {
			$scope.suggestions = response.data;
			
		}, function onError(response) {
		});
	};
	
	/**
	 * Controla as escolhas de sugestões feitas pelo user.
	 */
	$scope.checkedSuggestion = function(suggestion){
		var index = $scope.suggestions.indexOf(suggestion);
		var elementClicked = $(".aqt-close").eq(index);
		var elementIcon = $('.js-icon').eq(index);
		
		if(elementClicked.hasClass("alert-success")){
			elementClicked.removeClass('alert-success');
			elementIcon.removeClass('fa-close');
			elementIcon.addClass('fa-check')
			var indexChoose = chosenSuggestions.indexOf(suggestion);
			chosenSuggestions.splice(indexChoose, 1);
			anableButton(chosenSuggestions);
		}
		else{
			elementClicked.addClass('alert-success'); 
			elementIcon.removeClass('fa-check');
			elementIcon.addClass('fa-close')
			chosenSuggestions.push(suggestion);
			anableButton(chosenSuggestions);
		}
	};
	
	/**
	 * Registra na API as escolhas de sugestões do user.
	 */
	$scope.registerChosenSuggestions = function(question){
		if(chosenSuggestions.length > 0){
			
			var questionWrapper = {};
			questionWrapper.question = question;
			questionWrapper.suggestions = chosenSuggestions;
			
			$http({
				method : 'POST',
				url : URI+'/analyzer/suggestions',
				data : questionWrapper
				
			}).then(function onSuccess() {
				$location.path('/listQuestions')
				
			}, function onError() {
				
			});
		}
	};
	
	function anableButton(chosenSuggestions){
		if(chosenSuggestions.length > 0){
			buttonGetSug.prop('disabled', true)
			buttonCompletter.prop('disabled', false);
		}else{
			buttonGetSug.prop('disabled', false)
			buttonCompletter.prop('disabled', true);
		}
	}
});