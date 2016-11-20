aqtApp.controller("adminController", function($scope, userService, $location,
		localStorageService) {


	$scope.adminAccess = function() {
		$location.path('/adminUsers');
	};
});