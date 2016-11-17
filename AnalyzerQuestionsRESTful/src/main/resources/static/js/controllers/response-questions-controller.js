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
	var elemetQuestion = $("#body-detail-description");
	
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
				$scope.question = chosenQuestions[0];
				elemetQuestion.append($scope.question.descritptionHtml);
			}, function(data) {
	});

	var cont = 0;
	$scope.next = function() {
		cont++;
		
		elemetQuestion.empty();
		$scope.question = chosenQuestions[cont];
		elemetQuestion.append($scope.question.descritptionHtml);
	};
	$scope.back = function() {
		cont--;
		var elemetQuestion = $("#body-detail-description");
		elemetQuestion.empty();
		$scope.question = chosenQuestions[cont];
		elemetQuestion.append($scope.question.descritptionHtml);
	}
});