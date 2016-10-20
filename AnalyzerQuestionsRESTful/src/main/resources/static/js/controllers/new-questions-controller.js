aqtApp.controller('newQuestionController', function($scope, $http) {
	
	$scope.suggestions = [];

	$scope.newQuestion = function(question) {
		
		post = $('#editor-f').data('markdown').parseContent();
	    console.log(post);
	    
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
	
	$scope.checkedSuggestion = function(suggestion, isChecked){
		var index = $scope.suggestions.indexOf(suggestion);
		var myEl = $(".aqt-close").eq(index);
		if(isChecked){
			myEl.addClass('alert-success'); 
		}
		else{
			myEl.removeClass('alert-success');
		}
	};
});