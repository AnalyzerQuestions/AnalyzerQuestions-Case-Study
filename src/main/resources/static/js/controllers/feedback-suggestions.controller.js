/**
 */
aqtApp.controller('FeedbackController', function($scope, userService, $http,
		$location, localStorageService) {

	$scope.feedback = {};
	var userStorage = localStorageService.get("aqt-user");
	var user = {};

	/**
	 * 
	 */
	$scope.registerFeedback = function() {
		userService.getById(userStorage.id).then(function(response) {
			user = response.data;
			if(user.questionWrapper) {
				user.questionWrapper.feedback = $scope.feedback;				
			}else {
				user.questionWrapper = {};
				user.questionWrapper.feedback = $scope.feedback;
			}
			userService.updateUser(user).then(function onSuccess(response) {
				$location.path('/step2')
			}, function onError() {

			});
		});
	};
});