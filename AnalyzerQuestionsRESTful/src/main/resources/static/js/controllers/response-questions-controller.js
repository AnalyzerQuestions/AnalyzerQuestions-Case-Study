/**
 * Controller responsável pela manipulação do fragmento de página
 * list-questions.html
 * 
 * @created
 * @date 21-10-16.
 */
aqtApp.controller("responseQuestionController", function($scope, $http,
		$location) {

	const
	URI = 'http://localhost:8080';
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
			$scope.nextQuestion.next();

		}, function onError(response) {

		});
	};

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

	$scope.getSelectedQuestions();

});