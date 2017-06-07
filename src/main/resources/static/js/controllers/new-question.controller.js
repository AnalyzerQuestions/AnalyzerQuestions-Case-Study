/**
 * Controller responsável pela manipulação do fragmento de página
 * new-question.html
 * 
 * @created by Franck Aragão
 * @date 20-10-16.
 */
aqtApp.controller('newQuestionController', function($scope, userService, $http,
		$location, localStorageService, analyzerService) {

	var chosenSuggestions = [];
	$scope.suggestions = [];
	$scope.question = {}
	$scope.question.descritptionHtml = post = $('#editor-f').data('markdown').parseContent();

	var userStorage = localStorageService.get("aqt-user");
	var user = {};

	/**
	 * Submete uma nova pergunta à API e obtem sugestões.
	 */
	$scope.getSuggestions = function() {
		
		if($scope.question.title && $scope.question.description){
			var user = userStorage;
			user.question = $scope.question;
			analyzerService.analyzer(user, function(response) {
				$scope.suggestions = response;
			});
		}
	};
	
	/**
	 * Controla as escolhas de sugestões feitas pelo user.
	 */
	$scope.checkedSuggestion = function(suggestion) {
		var index = $scope.suggestions.indexOf(suggestion);
		var elementClicked = $(".aqt-close").eq(index);
		var elementIcon = $('.js-icon').eq(index);
		if (elementClicked.hasClass("alert-success")) {
		
			elementClicked.removeClass('alert-success');
			elementIcon.removeClass('fa-close');
			elementIcon.addClass('fa-check')
			
			var indexChoose = chosenSuggestions.indexOf(suggestion);
			chosenSuggestions.splice(indexChoose, 1);
		
		} else {
			elementClicked.addClass('alert-success');
			elementIcon.removeClass('fa-check');
			elementIcon.addClass('fa-close')
			chosenSuggestions.push(suggestion.header);
		}
	};

	/**
	 * Registra na API as escolhas de sugestões do user.
	 */
	$scope.registerChosenSuggestions = function() {

		var questionWrapper = {};
		questionWrapper.suggestions = chosenSuggestions;
		$scope.question.questionType = "CHANGED_WITH_SUGGESTION";
		questionWrapper.question = $scope.question;
		
		
		userService.getById(userStorage.id).then(
			function(response) {
				user = response.data;
				user.questionWrapper = questionWrapper;
				userService.updateUser(user).then(
					function onSuccess() {
						$location.path('/feedback')

					}, function onError() {
				});
		}, function(data) {

		});
	};
});