/**
 * Controller responsável pela manipulação do fragmento de  página list-questions.html
 * 
 * @created  @date 21-10-16.
 */
aqtApp.controller("responseQuestionController", function($scope, $http, $location) {
	
	const URI = 'http://localhost:8080';
	var chosenQuestions = [];
	$scope.question = {};
	
	/**
	 * Obtém lista de perguntas ecolhidas do WS.
	 */
	$scope.getSelectedQuestions = function() {

		$http({
			method : 'GET',
			url : URI + '/analyzer/getChonseQuestions'

		}).then(function onSuccess(response) {
			chosenQuestions = response.data;
			$scope.nextQuestion();

		}, function onError(response) {

		});
	};
	
	
	$scope.nextQuestion = function() {
		var cont = 0;
		
		$scope.question = chosenQuestions[cont];
		var elemetQuestion = $("#body-detail-description");
		elemetQuestion.append($scope.question.descritptionHtml);
		
		var next = function(){
			cont++;
			console.log(cont);
			$scope.question = chosenQuestions[cont];
			var elemetQuestion = $("#body-detail-description");
			elemetQuestion.append($scope.question.descritptionHtml);
		}
		
		return {
			next:next
		}
	};
	

	$scope.getSelectedQuestions();
	
});