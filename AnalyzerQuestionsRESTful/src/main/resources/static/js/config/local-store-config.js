aqtApp.config(['cfpLoadingBarProvider', function(cfpLoadingBarProvider) {
    cfpLoadingBarProvider.parentSelector = '#loading-bar-container';
    cfpLoadingBarProvider.spinnerTemplate = '<div><i class="fa fa-spinner fa-pulse fa-2x fa-fw"></i></div>';
}])