/**
 * Controller responsável pela manipulação do fragmento de  página l-questions.html
 * 
 * @created by Franck Aragão @date 21-10-16.
 */
aqtApp.controller("listQuestionController", function($scope, $http) {

	const URI = 'http://localhost:8080';
	$scope.questions = [];

	/**
	 * Obtém lista de perguntas do WS.
	 */
	$scope.getQuestions = function() {

		$http({
			method : 'GET',
			url : URI + '/analyzer/getQuestions'

		}).then(function onSuccess(response) {
			$scope.questions = response.data;

		}, function onError(response) {

		});
	};
	
	/**
	 * Evento de click no item de lista clicado.
	 */
	$scope.selectedQuestion = function(question) {
		var index = $scope.questions.indexOf(question);
		
		var elementClicked = $(".list-group-item").eq(index);
		elementClicked.addClass('active');
		
	};
	
	$scope.getQuestions();
});