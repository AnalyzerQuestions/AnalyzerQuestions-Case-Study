aqtApp.controller("configController", function($scope, aqtConfig, questionService, userService, growl) {

	$scope.config = {};
	$scope.clicked = {};
	var isUpdated = false;
	var isClicked = false;
	var previusMotive = "";

	aqtConfig.getTime().then(function(response) {
		$scope.config = response.data;
	});

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

	$scope.saveMotive = function() {
		if(isClicked){
			if (!isUpdated) {
				saveMotiveClicked($scope.clicked.motive);
			} else {
				updateMotiveClicked($scope.clicked.motive);
			}
		}else{
			
		}
	};
	
	var saveMotiveClicked = function(motive){
		$scope.config.optionsQuestionsClicked.push(motive);
		$('#optionModal').modal('hide');
		$scope.update();
	};

	$scope.removeMotiveClicked = function(motive) {
		var index = $scope.config.optionsQuestionsClicked.indexOf(motive);
		$scope.config.optionsQuestionsClicked.splice(index, 1);
		$scope.update();
	};

	var updateMotiveClicked = function(motive) {
		var index = $scope.config.optionsQuestionsClicked.indexOf(previusMotive);
		$scope.config.optionsQuestionsClicked[index] = motive;
		$('#optionModal').modal('hide');
		$scope.update();
	};

	$scope.update = function() {
		aqtConfig.updateTime($scope.config).then(function(response) {
			reset();
		});
	};

	$scope.getSuggestions = function() {
		aqtConfig.getSuggestions().then(function(response) {
			console.log(response.data);
		});
	};

	var reset = function() {
		$scope.clicked = angular.copy($scope.clicked = {});
		motive = "";
		isUpdated = false;
	};
});