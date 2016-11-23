aqtApp.controller("userController",function($scope, userService, $location, localStorageService,
				DTOptionsBuilder, DTColumnDefBuilder, $routeParams) {

			$scope.users = [];
			$scope.user = {};

			if ($routeParams.userId) {
				userService.getById($routeParams.userId).$promise.then(
						function(response) {
							$scope.user = response;

						}, function(response) {
							console.log("Erro na requisição " + response);
						});
			};

			$scope.dtOptions = DTOptionsBuilder.newOptions()
					.withPaginationType('full_numbers').withDisplayLength(10);

			$scope.dtColumnDefs = [
					DTColumnDefBuilder.newColumnDef(0).notSortable(),
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
