var aqtApp = angular.module("aqtApp", [ 'ngResource', 'angular-growl',
		'datatables', 'datatables.bootstrap', 'ngRoute', 'LocalStorageModule',
		'angular-loading-bar', 'ngAnimate', 'infinite-scroll' ]);

/**
 * Registra token no cabeçalho HTTP
 */
aqtApp.config(function($httpProvider) {
	$httpProvider.interceptors.push("tokenInterceptor");
});

aqtApp.run([ '$rootScope', '$location', function($rootScope, $location) {

	$rootScope.disableBtnAdmin = function() {
		return localStorage.getItem("adminToken");
	}

	$rootScope.logoutAdmin = function() {
		localStorage.clear();
	}

	$rootScope.$on('$locationChangeStart', function(event, next, current) {

		if (localStorage.getItem("adminToken")) {
			if ($location.path() === '/aqtAdmin') {
				$location.path('/adminUsers');
			}
		}
	});
} ]);
