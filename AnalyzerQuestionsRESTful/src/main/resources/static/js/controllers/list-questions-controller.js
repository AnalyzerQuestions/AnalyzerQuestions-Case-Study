/**
 * Controller responsável pela manipulação do fragmento de  página list-questions.html
 * 
 * @created by Franck Aragão @date 21-10-16.
 */
aqtApp.controller("listQuestionController", function($scope, $http, $location) {

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
		
	};
	
	/**
	 * Cronometro
	 */
	var startCronometer = function(){
		timer = new Timer();
		timer.start({countdown: true, startValues: {seconds: 300}});
		$('.cronometer').html(timer.getTimeValues().toString());
		timer.addEventListener('secondsUpdated', function (e) {
			$('.cronometer').html(timer.getTimeValues().toString());
		});
		timer.addEventListener('targetAchieved', function (e) {
			$('.cronometer').html('');
			$('#end-time').modal('toggle')
		});
	}; 
	
	startCronometer();
	$scope.getQuestions();
	
});