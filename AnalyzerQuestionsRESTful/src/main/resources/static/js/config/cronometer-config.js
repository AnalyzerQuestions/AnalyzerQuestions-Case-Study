aqtApp.service('aqtConfig', function($http) {

	this.getTime = function(){
		return $http.get('/config/config.json');
	};
	
	this.updateTime = function(config){
		return $http.post('/config', config);
	};
	
	this.getSuggestions = function(){
		return $http.get('/suggestions');
	}

});