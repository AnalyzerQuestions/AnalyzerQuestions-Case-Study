/**
 * Controller responsável pela manipulação do fragmento de  página new-question.html
 * 
 * @created by Franck Aragão 20-10-16.
 */
aqtApp.controller('newQuestionController', function($scope, $http) {
	
	$scope.suggestions = [];
	var chosenSuggestions = [];

	/**
	 * Submete uma nova pergunta à API.
	 */
	$scope.newQuestion = function(question) {
		
		post = $('#editor-f').data('markdown').parseContent();
	    console.log(post);
	    
		$http({
			method : 'POST',
			url : 'http://localhost:8080/analyzer',
			data : question,

		}).then(function onSucces(response) {
			$scope.suggestions = response.data;
			
		}, function onError(response) {
		});
	};
	
	/**
	 * Controla as escolhas de sugestões feitas pelo user.
	 */
	$scope.checkedSuggestion = function(suggestion, isChecked){
		var index = $scope.suggestions.indexOf(suggestion);
		var myEl = $(".aqt-close").eq(index);
		if(isChecked){
			myEl.addClass('alert-success'); 
			chosenSuggestions.push(suggestion);
		}
		else{
			myEl.removeClass('alert-success');
			var indexChoose = chosenSuggestions.indexOf(suggestion);
			chosenSuggestions.splice(indexChoose, 1);
		}
	};
});