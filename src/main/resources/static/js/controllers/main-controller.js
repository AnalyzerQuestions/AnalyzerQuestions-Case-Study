aqtApp.controller("mainController", function($scope, $location, $route, $routeParams, localStorageService){
	
	$scope.$location= $location;
	$scope.$route=$route;
	$scope.$routeParams= $routeParams;
});