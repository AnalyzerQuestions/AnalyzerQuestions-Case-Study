aqtApp.controller("mainController", function($scope, $location, $route, $routeParams, localStorageService){
	
	$scope.adminLogged = localStorage.getItem("adminToken");  
	
	$scope.logout = function(){
		localStorage.clearAll;
	};
	
	$scope.$location= $location;
	$scope.$route=$route;
	$scope.$routeParams= $routeParams;
});