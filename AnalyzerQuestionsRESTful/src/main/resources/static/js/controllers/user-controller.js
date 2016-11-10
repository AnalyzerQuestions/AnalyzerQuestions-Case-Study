aqtApp.controller("userController", function($scope, $http, $location) {
	
	$scope.user = {};
	
	$scope.register = function() {
		$http({
			method : 'POST',
			url : URI+'/user',
			data : user,

		}).then(function onSucces(response) {
			$scope.user = response.data;
			
		}, function onError(response) {
			
		});
	};
	
});