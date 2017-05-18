/**
 */
aqtApp.controller('FeedbackController', function($scope, userService, $http,
		$location, localStorageService) {

	$scope.feedback = {};
	$scope.feedback.isImportant = true;
	var userStorage = localStorageService.get("aqt-user");
	var user = {};

	/**
	 * 
	 */
	$scope.registerFeedback = function() {

		userService.getById(userStorage.id).$promise.then(function(data) {
			user = data;
			user.questionWrapper.feedback = $scope.feedback;
			userService.updateUser(user).$promise.then(function onSuccess() {
				$location.path('/step2')

			}, function onError() {

			});
		}, function(data) {

		});
	};
});