aqtApp.controller('newQuestionController', function($scope, $http) {
	
	$scope.suggestions = [];

	$scope.newQuestion = function(question) {
		$http({

			method : 'POST',
			url : 'http://localhost:8080/analyzer',
			data : question,

		}).then(function onSucces(response) {
			$scope.suggestions = response.data;
			console.log($scope.suggestions);
			
			
		}, function onError(response) {
			
		});
	};

});