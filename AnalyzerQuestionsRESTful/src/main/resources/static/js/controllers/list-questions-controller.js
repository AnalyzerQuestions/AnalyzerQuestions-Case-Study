/**
 * Controller responsável pela manipulação do fragmento de  página list-questions.html
 * 
 * @created by Franck Aragão @date 21-10-16.
 */
aqtApp.controller("listQuestionController", function($scope, $http, $location) {

	const URI = 'http://localhost:8080';
	$scope.questions = [];
	$scope.questionSelected = {};
	var chosenQuestions = [];
	var clickedQuestions = [];
	var bodyDetail = $("#body-detail-description");
	

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
		clickedQuestions.push(question);
		
		bodyDetail.append($scope.questionSelected.descritptionHtml);
		console.log(bodyDetail);
	};
	
	/**
	 * Evento de escolha para o user responder.
	 */
	$scope.selectedChosenQuestion = function(){
		chosenQuestions.push($scope.questionSelected);
		var index = $scope.questions.indexOf($scope.questionSelected);
		var groupList = $(".aqt-confirm").eq(index);
		groupList.append('<span class="label label-success">SELECIONADA</span>'); 
		
		$scope.questionSelected = {};
	}
	
	$scope.closeDetailQuestion = function() {
		$scope.questionSelected = {};
	};
	
	/**
	 * Passa cliques e escolhas do user para o API.
	 */
	$scope.endChosenQuestion = function(){
		var chosenQuestion = {};
		chosenQuestion.clickedQuestions = clickedQuestions;
		chosenQuestion.chosenQuestions = chosenQuestions;
		
		removeFocusModal();
		
		$http({
			method: 'POST',
			url : URI + '/analyzer/choices',
			data : chosenQuestion
			
		}).then(function onSuccess(response) {
			
			$location.path('/responseQuestions')
			
		}, function onError(response) {
			
		});
	};
	
	/**
	 * inicia cronometro, quando a tela de lista de pergunta é iniciada.
	 */
	$scope.startCronometer = function(){
		timer = new Timer();
		timer.start({countdown: true, startValues: {seconds: 180}});
		$('.cronometer').html(timer.getTimeValues().toString());
		timer.addEventListener('secondsUpdated', function (e) {
			$('.cronometer').html(timer.getTimeValues().toString());
		});
		timer.addEventListener('targetAchieved', function (e) {
			$('.cronometer').html('');
			$('#end-time').modal('toggle')
		});
	};
	
	/**
	 * Remove classes do componente modal do bootstrap.
	 * Forma para resolver problema da chamada via router para
	 * outra view.
	 */
	var removeFocusModal = function (){
		$('#end-time').modal('hide');
		$('body').removeClass('modal-open');
		$('.modal-backdrop').remove();
	}
	
	$scope.getQuestions();
	$scope.startCronometer();
	
});