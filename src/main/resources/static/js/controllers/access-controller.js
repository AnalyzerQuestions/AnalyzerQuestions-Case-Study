aqtApp.controller("accessController", function($scope, userService, $location, localStorageService) {

	$scope.user = {};
	
	localStorageService.clearAll();

	$scope.register = function() {
		userService.saveUser($scope.user).$promise.then(

		function(value) {
			$location.path('/step1');
			return localStorageService.set("aqt-user", value);

		}, function(error) {

		});
	};	
});