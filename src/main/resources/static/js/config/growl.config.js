aqtApp.config(['growlProvider', function (growlProvider) {
    growlProvider.globalTimeToLive(3000);
    growlProvider.globalDisableCloseButton(true);
    growlProvider.globalDisableCountDown(true);
}]);