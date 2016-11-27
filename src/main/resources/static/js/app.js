var aqtApp = angular.module("aqtApp", ['ngResource','angular-growl','datatables', 'datatables.bootstrap', 'ngRoute','LocalStorageModule', 'angular-loading-bar', 'ngAnimate', 'infinite-scroll']);

aqtApp.config (function($httpProvider){
	$httpProvider.interceptors.push("tokenInterceptor");
});


