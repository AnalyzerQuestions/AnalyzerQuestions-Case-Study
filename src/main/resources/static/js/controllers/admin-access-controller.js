aqtApp.controller("adminController", function($scope, $http, userService, $location, growl) {

	$scope.key = "";
	
	$scope.adminAccess = function() {
		
		$http({
		    url: "/user/adminAccess", 
		    method: "GET",
		    params: {"key" : $scope.key}
		 }).then(
					function(response) {
						localStorage.setItem("adminToken", response.data.token);
						$location.path('/adminUsers');

					}, function(response) {
						growl.error("Key Inválida");
					});
		}
});