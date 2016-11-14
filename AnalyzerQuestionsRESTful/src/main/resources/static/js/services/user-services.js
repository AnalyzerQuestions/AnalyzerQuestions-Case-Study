aqtApp.factory('resourceService', function($resource) {
	
	return $resource('/analyzer/user/:userId', null, {
		update : {
			method: 'PUT'
		}
	});
})

aqtApp.service('userService', function(resourceService){
	
	this.saveUser = function(user){
		return resourceService.save(user);
	};
	
	this.updateUser = function(user) {
		return resourceService.update(cliente);
	};	
});