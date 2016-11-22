aqtApp.controller("configController", function($scope, cronometerConfig, userService, growl) {

	$scope.config = {};

	cronometerConfig.getTime().then(function(response) {
		$scope.config = response.data;
	});
	
	$scope.update = function(){
		
		cronometerConfig.updateTime($scope.config).then(function(response) {
			growl.success("Configurações salvas");
		}, function(){
			growl.error('Deu Zebra');
		});
		
	};
});