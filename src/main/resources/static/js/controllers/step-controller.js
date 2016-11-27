aqtApp.controller("stepController", function($scope, aqtConfig) {

	$scope.config = {};

	aqtConfig.getConfig().then(function(response) {
		$scope.config = response.data;
	});
});