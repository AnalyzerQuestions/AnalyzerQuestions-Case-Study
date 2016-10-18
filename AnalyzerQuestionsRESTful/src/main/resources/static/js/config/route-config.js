aqtApp.config(function($routeProvider, $locationProvider) {

	$routeProvider.when("/newQuestion", {
		templateUrl : 'view/new-question.html',
		controller : 'newQuestionController'

	}).otherwise({
		redirectTo : '/'
	});
	
	$locationProvider.html5Mode(true);

});