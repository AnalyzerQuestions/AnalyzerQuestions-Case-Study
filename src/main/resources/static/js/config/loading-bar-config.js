aqtApp.config(function(localStorageServiceProvider) {
	localStorageServiceProvider.setPrefix('aqt')
								.setStorageType('sessionStorage')
								.setNotify(true, true)
});