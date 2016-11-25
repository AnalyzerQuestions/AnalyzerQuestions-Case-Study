aqtApp.controller("configController", function($scope, aqtConfig, questionService, userService, growl) {

	$scope.config = {};
	$scope.suggestion = {};
	$scope.clicked = {};
	var isUpdated = false;
	var isClicked = false;
	var previusMotive = "";
	
	/**
	 * 
	 */
	aqtConfig.getConfig().then(function(response) {
		$scope.config = response.data;
	});

	/**
	 * 
	 */
	$scope.openModal = function(motive, isUp, isCli) {
		isUpdated = isUp;
		isClicked = isCli;
		if (isUp) {
			previusMotive = motive;
			$scope.clicked.motive = motive;
		} else {
			reset();
		}
	};

	/**
	 * 
	 */
	$scope.saveMotive = function() {
		if(isClicked){
			if (!isUpdated) {
				saveMotiveClicked($scope.clicked.motive);
			} else {
				updateMotiveClicked($scope.clicked.motive);
			}
		}else{
			if (!isUpdated) {
				saveMotiveChosen($scope.clicked.motive);
			} else {
				updateMotiveChosen($scope.clicked.motive);
			}
		}
		reset();
	};
	
	/**
	 * 
	 */
	var saveMotiveClicked = function(motive){
		$scope.config.optionsQuestionsClicked.push(motive);
		$('#optionModal').modal('hide');
	};

	/**
	 * 
	 */
	$scope.removeMotiveClicked = function(motive) {
		var index = $scope.config.optionsQuestionsClicked.indexOf(motive);
		$scope.config.optionsQuestionsClicked.splice(index, 1);
	};

	/**
	 * 
	 */
	var updateMotiveClicked = function(motive) {
		var index = $scope.config.optionsQuestionsClicked.indexOf(previusMotive);
		$scope.config.optionsQuestionsClicked[index] = motive;
		$('#optionModal').modal('hide');
	};
	
	/**
	 * 
	 */
	var saveMotiveChosen = function(motive){
		$scope.config.optionsQuestionsChosen.push(motive);
		$('#optionModal').modal('hide');
	};
	
	/**
	 * 
	 */
	$scope.removeMotiveChosen = function(motive) {
		var index = $scope.config.optionsQuestionsChosen.indexOf(motive);
		$scope.config.optionsQuestionsChosen.splice(index, 1);

	};
	
	/**
	 * 
	 */
	var updateMotiveChosen= function(motive) {
		var index = $scope.config.optionsQuestionsChosen.indexOf(previusMotive);
		$scope.config.optionsQuestionsChosen[index] = motive;
		$('#optionModal').modal('hide');
	};

	/**
	 * 
	 */
	$scope.update = function() {
		aqtConfig.updateTime($scope.config).then(function(response) {
			growl.success("Configurações salvas");
			reset();
		});
	};
	
	/**
	 * 
	 */
/*	aqtConfig.getSuggestions().then(function(response) {
		$scope.config.suggestions = response.data;
	});*/
	
	$scope.saveSuggestion = function(){
		aqtConfig.generateSuggestions().forEach(function(sug) {
			aqtConfig.saveSuggestion(sug).then(function(response){
				console.log(response);
			});
		})
	};
	

	/**
	 * 
	 */
	var reset = function() {
		$scope.clicked = angular.copy($scope.clicked = {});
		motive = "";
		isUpdated = false;
	};
});