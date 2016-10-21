aqtApp.controller("listQuestionController", function($scope, $http) {

	const URI = 'http://localhost:8080';
	$scope.questions = [];

	$scope.getQuestions = function() {

		$http({
			method : 'GET',
			url : URI + '/analyzer/getQuestions'

		}).then(function onSuccess(response) {
			$scope.questions = response.data;

		}, function onError(response) {

		});
	};
	
	$scope.selectedQuestion = function(question) {
		var index = $scope.questions.indexOf(question);
		
		var elementClicked = $(".list-group-item").eq(index);
		elementClicked.addClass('active');
		
	};
	
	$scope.getQuestions();
});