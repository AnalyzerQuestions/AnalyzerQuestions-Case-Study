/**
 * Controller responsável pela manipulação do fragmento de página
 * list-questions.html
 * 
 * @created
 * @date 21-10-16.
 */
aqtApp.controller("responseQuestionController", function($scope, userService, questionService, $location, localStorageService) {

	var chosenQuestions = [];
	$scope.optionsQuestionsClicked = questionService.getOptionsQuestionsClicked();
	$scope.checkedQuestionsClicked = [];
	$scope.question = {};
	var userStorage = localStorageService.get("aqt-user");
	
    $scope.toggleCheck = function (option) {
        if ($scope.checkedQuestionsClicked.indexOf(option) === -1) {
            $scope.checkedQuestionsClicked.push(option);
        } else {
            $scope.checkedQuestionsClicked.splice($scope.checkedQuestionsClicked.indexOf(option), 1);
        }
        console.log($scope.checkedQuestionsClicked);
    };
	
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
			$scope.question = chosenQuestions[this.cont];
			elemetQuestion.append($scope.question.descritptionHtml);
			this.cont++;
		}
	}
});