/**
 * Controller responsável pela manipulação do fragmento de  página list-questions.html
 * 
 * @created  @date 21-10-16.
 */
aqtApp.controller("responseQuestionController", function($scope, $http, $location) {
	
	const URI = 'http://localhost:8080';
	$scope.questions = [];
	$scope.questionSelected = {};
	var chosenQuestions = [];
	var clickedQuestions = [];
	
	/**
	 * Obtém lista de perguntas ecolhidas do WS.
	 */
	$scope.getSelectedQuestions = function() {

		$http({
			method : 'GET',
			url : URI + '/analyzer/getChoices'

		}).then(function onSuccess(response) {
			$scope.questions = response.data;

		}, function onError(response) {

		});
	};
	

	
	$scope.getSelectedQuestions();
	
});