/**
 * Controller responsável pela manipulação do fragmento de  página list-questions.html
 * 
 * @created  @date 21-10-16.
 */
aqtApp.controller("responseQuestionController", function($scope, $http, $location) {
	
	const URI = 'http://localhost:8080';
	$scope.chosenQuestions = [];
	
	/**
	 * Obtém lista de perguntas ecolhidas do WS.
	 */
	$scope.getSelectedQuestions = function() {

		$http({
			method : 'GET',
			url : URI + '/analyzer/getChonseQuestions',

		}).then(function onSuccess(response) {
			$scope.chosenQuestion = response.data;
			
		}, function onError(response) {

		});
	};
	

	
	$scope.getSelectedQuestions();
	
});