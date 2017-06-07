/**
 * Controller responsável pela manipulação do fragmento de página
 * list-questions.html
 * 
 * @created Frank Aragão
 * @date 21-10-16.
 */
aqtApp.controller("responseQuestionController", function($scope, userService,
		questionService, aqtConfig, $location, localStorageService, growl) {

	var vm = this;
	vm.chosenQuestions = [];
	vm.optionsQuestionsClicked = [];
	vm.optionsQuestionsChosen = [];
	vm.checkedQuestionsClicked = [];
	vm.question = {};
	vm.other = false;
	vm.otherSet = false;
	vm.otherText = '';
	vm.progress = 0;

	var userStorage = localStorageService.get("aqt-user");
	var elemetQuestion = $("#body-detail-description");
	var user = {};

	/**
	 * 
	 */
	questionService.getOptionsQuestionsClicked().then(function(response) {
		vm.optionsQuestionsClicked = response.data.optionsQuestionsClicked;
	});

	/**
	 * 
	 */
	questionService.getOptionsQuestionsChosen().then(function(response) {
		vm.optionsQuestionsChosen = response.data.optionsQuestionsChosen;
	});

	/**
	 * 
	 */
	vm.toggleCheck = function(option) {
		if (vm.checkedQuestionsClicked.indexOf(option) === -1) {
			vm.checkedQuestionsClicked.push(option);
		} else {
			vm.checkedQuestionsClicked.splice(vm.checkedQuestionsClicked
					.indexOf(option), 1);
		}
	};

	/**
	 * 
	 */
	userService.getById(userStorage.id).then(function(response) {
		user = response.data;
		vm.chosenQuestions = response.data.chosenQuestionsWrapper.chosenQuestions;
		setQuestionInHtml(cont);
	}, function(data) {
	});

	/**
	 * 
	 */
	vm.nextQuestion = function() {
		validOtherInput();
		var checked = vm.checkedQuestionsClicked.length;

		if (checked) {
			if (vm.disableBtnNext()) {
				localStorageService.clearAll();
				$location.path('/final');
			}
			if (vm.other) {
				if (vm.otherSet) {
					next();
				} else {
					growl.error("Escolha/Descreva o motivo");
				}
			} else {
				next();
			}
		} else {
			growl.error("Escolha/Descreva o motivo");
		}
	};

	/**
	 * 
	 */
	function validOtherInput() {
		if (vm.other) {
			if (vm.frmOptions.$valid) {
				vm.checkedQuestionsClicked.push(vm.otherText);
				vm.otherSet = true;
			} else {
				growl.error("Escolha/Descreva o motivo");
			}
		}
	}

	/**
	 * 
	 */
	var cont = 0;
	var next = function() {
		cont++;
		vm.progress = cont;
		updateQuestion(vm.question);
		setQuestionInHtml(cont);
	};

	/**
	 * 
	 */
	var updateQuestion = function(question) {
		question.motives = vm.checkedQuestionsClicked;

		questionService.updateQuestion(question).$promise.then(function(
				response) {
			reset();
		}, function(response) {
		});
	};

	/**
	 * 
	 */
	var setQuestionInHtml = function(cont) {
		elemetQuestion.empty();
		if (!(vm.chosenQuestions.length === cont)) {
			vm.question = vm.chosenQuestions[cont];
			elemetQuestion.append(vm.question.descritptionHtml);
		}
	};

	/**
	 * 
	 */
	vm.disableBtnNext = function() {
		return vm.chosenQuestions.length - 1 === cont;
	};

	/**
	 * 
	 */
	var reset = function() {
		vm.checkedQuestionsClicked = angular.copy(vm.checkedQuestionsClicked = []);
		vm.other = false;
		vm.otherSet = false;
		vm.otherText = '';
	};
});
