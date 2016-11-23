aqtApp.service('aqtConfig', function($http) {

	this.getConfig = function(){
		return $http.get('config.json');
	};
	
	this.updateTime = function(config){
		return $http.post('/config', config);
	};
	
	this.getSuggestions = function(){
		return $http.get('/suggestions');
	}

});