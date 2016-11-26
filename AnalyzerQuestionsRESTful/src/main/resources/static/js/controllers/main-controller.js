aqtApp.controller("mainController", function($scope, $location, $route, $routeParams, localStorageService){
	
	$scope.adminLogged = localStorage.getItem("adminToken");  
	
	$scope.logout = function(){
		localStorage.clear();
	};
	
	$scope.$location= $location;
	$scope.$route=$route;
	$scope.$routeParams= $routeParams;
});