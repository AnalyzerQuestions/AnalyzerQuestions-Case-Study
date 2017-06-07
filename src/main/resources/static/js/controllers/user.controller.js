aqtApp.controller("userController",function($scope, userService, $location, localStorageService,
				DTOptionsBuilder, DTColumnDefBuilder, DTColumnBuilder, $routeParams) {

			$scope.users = [];
			$scope.user = {};

			if ($routeParams.userId) {
				userService.getById($routeParams.userId).then(
						function(response) {
							$scope.user = response.data;

						}, function(response) {
						});
			};

			$scope.dtOptions = DTOptionsBuilder.newOptions()
					.withPaginationType('simple_numbers').withDisplayLength(10).withBootstrap();

			$scope.dtColumnDefs = [
			        DTColumnDefBuilder.newColumnDef(0).notSortable(),
					DTColumnDefBuilder.newColumnDef(1).notSortable(),
					DTColumnDefBuilder.newColumnDef(2).notSortable(),
					DTColumnDefBuilder.newColumnDef(3).notSortable(),
					];

			var findAll = function() {
				userService.findAll().then(function(response) {
					$scope.users = response.data;

				}, function(response) {

				});
			};

			findAll();
		});
