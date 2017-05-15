var aqtApp = angular.module("aqtApp", [ 
                                        'ngResource', 
                                        'angular-growl',
                                        'datatables', 
                                        'datatables.bootstrap', 
                                        'ngRoute', 
                                        'LocalStorageModule',
                                        'angular-loading-bar',
                                        'ngAnimate',
                                        'infinite-scroll' 
                                        ]);

/**
 * Registra token no cabeçalho HTTP
 */
aqtApp.config(function($httpProvider) {
	$httpProvider.interceptors.push("tokenInterceptor");
});

/**
 * 
 */
aqtApp.run([ '$rootScope', '$location', 'localStorageService', function($rootScope, $location, localStorageService) {

	$rootScope.disableBtnAdmin = function() {
		return localStorage.getItem("adminToken");
	}

	$rootScope.logoutAdmin = function() {
		localStorage.clear();
	}

	$rootScope.$on('$locationChangeStart', function(event, next, current) {
		
		var routesRequereUser = ['/step1', '/step2', 'step3', '/newQuestion', '/listQuestions', '/responseQuestions'];
		var userStorage = localStorageService.get("aqt-user");
		
		if (!userStorage) {
			routesRequereUser.forEach(function(route) {
				if ($location.path() === route) {
					$location.path('/');
				}
			});
		}
		
		if (localStorage.getItem("adminToken")) {
			if ($location.path() === '/aqtAdmin') {
				$location.path('/adminUsers');
			}
		}
	});
} ]);
