aqtApp.controller("accessController", function($scope, userService, $location, localStorageService, growl) {

	$scope.user = {};
	
	localStorageService.remove("aqt-user");
		
	$scope.register = function() {
		userService.saveUser($scope.user).then(

		function(response) {
			if(response.status == 422){
				growl.error("Usuário com este e-mail já respondeu esta pesquisa.");
			}else{
				$location.path('/step1');
				localStorageService.set("aqt-user", response.data);
			}

		});
	};	
});