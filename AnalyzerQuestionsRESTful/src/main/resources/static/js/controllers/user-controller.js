aqtApp.controller("userController", function($scope, userService, $location, localStorageService) {

	$scope.user = {};

	$scope.register = function() {
		userService.saveUser($scope.user).$promise.then(

		function(value) {
			$location.path('/step1')
			return localStorageService.set("aqt-user", $scope.user);

		}, function(error) {

		});
	};
});