aqtApp.config(function($routeProvider, $locationProvider) {

	$routeProvider.when("/newQuestion", {
		templateUrl : 'view/new-question.html',
		controller : 'newQuestionController'

	}).when("/listQuestions", {
		templateUrl : 'view/list-questions.html',
		controller : 'listQuestionController'

	}).when("/responseQuestions", {
		templateUrl : 'view/response-questions.html',
		controller : 'responseQuestionController as vm'

	}).when("/", {
		templateUrl : 'view/login.html',
		controller : "accessController"

	}).when("/aqtAdmin", {
		templateUrl : 'view/admin.html',
		controller : 'adminController'

	}).when("/adminUsers", {
		templateUrl : 'view/users.html',
		controller : 'userController'

	}).when("/adminConfig", {
		templateUrl : 'view/config.html',
		controller : 'configController'
			
	}).when("/viewUser/:userId", {
		templateUrl : 'view/user-detail.html',
		controller : 'userController'

	}).when("/step1", {
		templateUrl : 'view/step-info1.html',
		controller : 'stepController'

	}).when("/step2", {
		templateUrl : 'view/step-info2.html',
		controller : 'stepController'

	}).when("/step3", {
		templateUrl : 'view/step-info3.html',
		controller : 'stepController'

	}).when("/final", {
		templateUrl : 'view/final.html',
		controller : 'stepController'

	}).otherwise({
		redirectTo : '/'
	});

});