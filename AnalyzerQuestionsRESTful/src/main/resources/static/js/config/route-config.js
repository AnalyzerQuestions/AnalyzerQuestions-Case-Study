aqtApp.config(function($routeProvider, $locationProvider) {

	$routeProvider.when("/newQuestion", {
		templateUrl : 'view/new-question.html',
		controller : 'newQuestionController'

	}).when("/listQuestions", {
		templateUrl : 'view/list-questions.html',
		controller : 'listQuestionController'

	}).when("/responseQuestions", {
		templateUrl : 'view/response-questions.html',
		controller : 'responseQuestionController'

	}).otherwise({
		redirectTo : '/'
	});

});