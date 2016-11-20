aqtApp.controller("adminController", function($scope, $http, userService, $location, growl) {

	$scope.key = "";
	
	$scope.adminAccess = function() {
		
		$http({
		    url: "/analyzer/user/adminAccess", 
		    method: "GET",
		    params: {"key" : $scope.key}
		 }).then(
					function(response) {
						console.log(response);
						$location.path('/adminUsers');

					}, function(response) {
						console.log(response);
						growl.error("Key Inválida");
					});
	}
});