/**
 * Controller responsável pela manipulação do fragmento de  página list-questions.html
 * 
 * @created by Franck Aragão @date 21-10-16.
 */
aqtApp.controller("listQuestionController", function($scope, $http, $location) {

	const URI = 'http://localhost:8080';
	$scope.questions = [];
	$scope.questionsLimit = 20;
	$scope.questionSelected = {};
	var chosenQuestions = [];
	var clickedQuestions = [];

	/**
	 * Obtém lista de perguntas do WS.
	 */
	$scope.getQuestions = function() {

		$http({
			method : 'GET',
			url : URI + '/analyzer/getQuestions'

		}).then(function onSuccess(response) {
			$scope.questions = response.data;
			$scope.loadMore();

		}, function onError(response) {

		});
	};
	
	/**
	 * Evento de click no item de lista clicado.
	 */
	$scope.selectedQuestion = function(question) {
		$scope.questionSelected = question;
		question.questionType = 'CLICABLE';
		clickedQuestions.push(question);
		
		var bodyDetail = $("#body-detail-description");
		bodyDetail.append($scope.questionSelected.descritptionHtml);
	};
	
	/**
	 * Evento de escolha para o user responder.
	 */
	$scope.selectedChosenQuestion = function(){
		var index = $scope.questions.indexOf($scope.questionSelected);
		var groupList = $(".aqt-confirm").eq(index);
		var btnDlgDetail = $('#btn-dlg-detail');
		
		if(groupList.hasClass('js-selected')){
			chosenQuestions.splice(index, 1);
			groupList.empty();
			$scope.questionSelected.questionType = 'CLICABLE';
			groupList.removeClass('js-selected');
			btnDlgDetail.text('QUERO RESPONDER ESTA PERGUNTA');
			
		}else{
			$scope.questionSelected.questionType = 'CHOSEN';
			chosenQuestions.push($scope.questionSelected);
			groupList.addClass('js-selected');
			groupList.append('<span class="label label-success">SELECIONADA</span>');
			btnDlgDetail.text('NÃO QUERO RESPONDER ESTA PERGUNTA');
		}
		
		clearModal();
	}
	
	$scope.closeDetailQuestion = function() {
		clearModal();
	};
	
	/**
	 * Passa cliques e escolhas do user para o API.
	 */
	$scope.endChosenQuestion = function(){
		var chosenQuestion = {};
		chosenQuestion.clickedQuestions = clickedQuestions;
		chosenQuestion.chosenQuestions = chosenQuestions;
		console.log(chosenQuestion);
		removeFocusModal();
		
		$http({
			method: 'POST',
			url : URI + '/analyzer/choices',
			data : chosenQuestion
			
		}).then(function onSuccess(response) {
			$location.path('/step3')
			
		}, function onError(response) {
			
		});
	};
	
	$scope.loadMore = function() {
	      var increamented = $scope.questionsLimit + 15;
	      $scope.questionsLimit = increamented > $scope.questions.length ? $scope.questions.length : increamented;
	    };
	
	/**
	 * inicia cronometro, quando a tela de lista de pergunta é iniciada.
	 */
	$scope.startCronometer = function(){
		timer = new Timer();
		timer.start({
			countdown: true, 
			startValues: {seconds: 183}
		});
		
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
	
	/**
	 * Limpa body do modal quando o mesmo é fechado.
	 * Isto é necessário devido ao append de elementos html
	 * que é adicionado no modal.
	 */
	var clearModal = function() {
		var bodyDetail = $("#body-detail-description");
		bodyDetail.empty();
		$scope.questionSelected = {};
	}
	
	$scope.getQuestions();
	$scope.startCronometer();
});