aqtApp.controller("configController", function($scope, aqtConfig, userService, growl) {

	$scope.config = {};

	aqtConfig.getTime().then(function(response) {
		$scope.config = response.data;
	});
	
	$scope.update = function(){
		aqtConfig.updateTime($scope.config).then(function(response) {
			growl.success("Configurações salvas");
		});
	};
	
	$scope.getSuggestions = function(){
		aqtConfig.getSuggestions().then(function(response) {
			console.log(response.data);
		});
	};
	
	$scope.getSuggestions();
	
});