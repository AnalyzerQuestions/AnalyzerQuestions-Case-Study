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

	}).when("/", {
		templateUrl : 'view/login.html',
		controller: "userController"
		
	}).when("/step1", {
		templateUrl : 'view/step-info1.html',
		
	}).when("/step2", {
		templateUrl : 'view/step-info2.html',
		
	}).when("/step3", {
		templateUrl : 'view/step-info3.html',
			
	}).otherwise({
		redirectTo : '/'
	});

});