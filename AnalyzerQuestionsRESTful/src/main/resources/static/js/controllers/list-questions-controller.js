/**
 * Controller responsável pela manipulação do fragmento de  página list-questions.html
 * 
 * @created by Franck Aragão @date 21-10-16.
 */
aqtApp.controller("listQuestionController", function($scope, $http) {

	const URI = 'http://localhost:8080';
	$scope.questions = [];
	var chosenQuestions = [];
	$scope.questionSelected = {};

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
		$scope.questionSelected = question;
		var index = $scope.questions.indexOf(question);
		
		var elementClicked = $(".list-group-item").eq(index);
		elementClicked.toggleClass("active");
		
		if(elementClicked.hasClass("active")){
			console.log(index, 'TEM class');
		}else{
			console.log(index, 'Não tem class')
		}
		
	};
	
	$scope.getQuestions();
});