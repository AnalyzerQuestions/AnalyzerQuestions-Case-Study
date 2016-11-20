aqtApp.controller("userController", function($scope, userService, $location, localStorageService) {

	$scope.user = {};
	$scope.users  = [];
	
	localStorageService.clearAll();

	$scope.register = function() {
		userService.saveUser($scope.user).$promise.then(

		function(value) {
			$location.path('/step1');
			return localStorageService.set("aqt-user", value);

		}, function(error) {

		});
	};
	
	var findAll = function(){
		userService.findAll().$promise.then(
			function(response){
				$scope.users = response;
				console.log($scope.users);
				
			}, function(response) {
			
		});
	};
	
	findAll();
	
});