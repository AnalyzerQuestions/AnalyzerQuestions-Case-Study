aqtApp.controller("mainController", function($scope, $location, $route, $routeParams, localStorageService){
	
	var userStorage = localStorageService.get("aqt-user");
	$scope.$location= $location;
	$scope.$route=$route;
	$scope.$routeParams= $routeParams;
});