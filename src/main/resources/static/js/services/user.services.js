aqtApp.factory('userService', function($http) {
	
	var service = {
			saveUser: saveUser,
			updateUser: updateUser,
			getById: getById,
			findAll: findAll,
			reset: reset
	};
	
	return service;
	
	function saveUser(user){
		return $http.post("analyzer/user",user);
	};
	
	function updateUser(user) {
		return $http.put("analyzer/user", user);
	};	
	
	 function getById(id) {
		return $http.get("analyzer/user/"+ id);
	};
	
	function findAll() {
		return $http.get('/admin/user');
	};
	
	function reset() {
		return $http.delete('/admin/user');
	}
});