/**
 * Controller responsável pela manipulação do fragmento de página
 * list-questions.html
 * 
 * @created by Franck Aragão
 * @date 21-10-16.
 */
aqtApp.controller("listQuestionController",function($scope, userService, aqtConfig, $http, $location,localStorageService) {

		$scope.questions = [];
		$scope.questionsLimit = 20;
		$scope.questionSelected = {};
		var chosenQuestions = [];

		var userStorage = localStorageService.get("aqt-user");
		
		/**
		 * Obtém lista de perguntas do WS.
		 */
		$scope.getQuestions = function() {

			$http({
				method : 'GET',
				url : '/analyzer/getQuestions'

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
			var bodyDetail = $("#body-detail-description");
			bodyDetail.append($scope.questionSelected.descritptionHtml);
			labelButtonSelection();
		};

		/**
		 * Evento de escolha para o user responder.
		 */
		var labelButtonSelection = function(){
			var index = $scope.questions.indexOf($scope.questionSelected);
			var groupList = $(".aqt-confirm").eq(index);
			var id = chosenQuestions.indexOf($scope.questionSelected);
			var btnSelection = $('#btn-dlg-detail');
			
			if(id === -1){
				$scope.questionSelected.questionType = 'CLICABLE';
				chosenQuestions.push($scope.questionSelected);
			}
			
			if(groupList.hasClass('js-selected')){
				btnSelection.text('NÃO QUERO RESPONDER ESTA PERGUNTA');
			}else{
				btnSelection.text('QUERO RESPONDER ESTA PERGUNTA');
			}
		};
		$scope.selectedChosenQuestion = function() {
			var index = $scope.questions.indexOf($scope.questionSelected);
			var id = chosenQuestions.indexOf($scope.questionSelected);
			var groupList = $(".aqt-confirm").eq(index);
			
			if (groupList.hasClass('js-selected')) {
				chosenQuestions.splice(id, 1);
				$scope.questionSelected.questionType = 'CLICABLE';
				chosenQuestions.push($scope.questionSelected);
				groupList.empty();
				groupList.removeClass('js-selected');

			} else {
				chosenQuestions.splice(id, 1);
				$scope.questionSelected.questionType = 'CHOSEN';
				chosenQuestions.push($scope.questionSelected);
				groupList.addClass('js-selected');
				groupList.append('<span class="label label-success">SELECIONADA</span>');
			}

			clearModal();
		}

		$scope.closeDetailQuestion = function() {
			clearModal();
		};

		/**
		 * Passa cliques e escolhas do user para o API.
		 */
		$scope.endChosenQuestion = function() {
			removeFocusModal();

			var chosenQuestion = {};

			chosenQuestion.chosenQuestions = chosenQuestions;
			
			if(chosenQuestions.length) {
				userService.getById(userStorage.id).$promise.then(
						function(data) {
							user = data;
							user.chosenQuestionsWrapper = chosenQuestion;
							userService.updateUser(user).$promise.then(
								function onSuccess(response) {
									$location.path('/step3');

								}, function onError(response) {

							});
						}, function(data) {
				});
			}else {
				$location.path('/final');
			}
		};

		$scope.loadMore = function() {
			var increamented = $scope.questionsLimit + 15;
			$scope.questionsLimit = increamented > $scope.questions.length ? $scope.questions.length : increamented;
		};

		/**
		 * inicia cronometro, quando a tela de lista de pergunta é
		 * iniciada.
		 */
		aqtConfig.getConfig().then(function(response){
			timer = new Timer();
			timer.start({
				countdown : true,
				startValues : {seconds : Number(response.data.time)}
			});

			$('.cronometer').html(timer.getTimeValues().toString());
			timer.addEventListener('secondsUpdated', function(e) {
				$('.cronometer').html(
					timer.getTimeValues().toString());
			});

			timer.addEventListener('targetAchieved', function(e) {
				$('.cronometer').html('');
				$('#end-time').modal('toggle')
			});
		});

		/**
		 * Remove classes do componente modal do bootstrap. Forma
		 * para resolver problema da chamada via router para outra
		 * view.
		 */
		var removeFocusModal = function() {
			$('#end-time').modal('hide');
			$('body').removeClass('modal-open');
			$('.modal-backdrop').remove();
		}

		/**
		 * Limpa body do modal quando o mesmo é fechado. Isto é
		 * necessário devido ao append de elementos html que é
		 * adicionado no modal.
		 */
		var clearModal = function() {
			var bodyDetail = $("#body-detail-description");
			bodyDetail.empty();
			$scope.questionSelected = {};
		}

		$scope.getQuestions();
	});