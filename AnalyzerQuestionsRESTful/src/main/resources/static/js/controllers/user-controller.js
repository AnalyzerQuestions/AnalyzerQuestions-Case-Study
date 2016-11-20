aqtApp.controller("userController", function($scope, userService, $location, localStorageService) {

	$scope.users  = [];
	
	var findAll = function(){
		userService.findAll().$promise.then(
			function(response){
				$scope.users = response;
				
			}, function(response) {
			
		});
	};
	
	findAll();
	
});