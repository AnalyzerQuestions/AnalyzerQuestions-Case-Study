aqtApp.service('cronometerConfig', function($http) {

	this.getTime = function(){
		return $http.get('/config/config.json');
	};
	
	this.updateTime = function(config){
		return $http.put('/config', config);
	};

});