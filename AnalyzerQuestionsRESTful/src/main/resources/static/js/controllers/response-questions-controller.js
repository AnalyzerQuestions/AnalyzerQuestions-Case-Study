/**
 * Controller responsável pela manipulação do fragmento de página
 * list-questions.html
 * 
 * @created
 * @date 21-10-16.
 */
aqtApp.controller("responseQuestionController", function($scope, userService, $location, localStorageService) {

	var chosenQuestions = [];
	$scope.question = {};
	var userStorage = localStorageService.get("aqt-user");

	userService.getById(userStorage.id).$promise.then(
			function(data) {
				chosenQuestions = data.chosenQuestionsWrapper.chosenQuestions;
				$scope.nextQuestion.next();
			}, function(data) {
	});

	$scope.nextQuestion = {
		cont : 0,

		next : function() {
			var elemetQuestion = $("#body-detail-description");
			elemetQuestion.empty();
			console.log(chosenQuestions);
			$scope.question = chosenQuestions[this.cont];
			elemetQuestion.append($scope.question.descritptionHtml);
			this.cont++;
		}
	}

});