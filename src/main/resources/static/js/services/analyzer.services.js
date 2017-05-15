(function () {
    angular.module("aqtApp")
        .factory("analyzerService", analyzerService);

    analyzerService.$inject = ['$http'];

    function analyzerService($http, Api) {

        var service = {
            analyzer: _analyzer
        };
        return service;

        function _analyzer(user, callback, callbackError) {
            $http.post("analyzer", user).then(function (response) {
                callback(response.data);
            }, function (response) {
                callbackError(response);

            });
        }
    };
})();