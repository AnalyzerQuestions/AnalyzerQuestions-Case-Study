aqtApp.controller("userController", function($scope, userService, $location,
		localStorageService, DTOptionsBuilder, DTColumnDefBuilder) {

	$scope.users = [];
	$scope.dtOptions = DTOptionsBuilder.newOptions()
	.withPaginationType('full_numbers')
	.withDisplayLength(10);
	
	$scope.dtColumnDefs = [ DTColumnDefBuilder.newColumnDef(0).notSortable().withOption('width', '8%'),
	                        DTColumnDefBuilder.newColumnDef(1),
	                        DTColumnDefBuilder.newColumnDef(2) ];

	var findAll = function() {
		userService.findAll().$promise.then(function(response) {
			$scope.users = response;

		}, function(response) {

		});
	};

	findAll();
});
