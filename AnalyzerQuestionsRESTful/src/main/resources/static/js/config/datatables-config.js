aqtApp.run(function(DTDefaultOptions) {

	DTDefaultOptions.setBootstrapOptions({
		TableTools : {
			classes : {
				container : 'btn-group',
				buttons : {
					normal : 'btn btn-danger'
				}
			}
		},
		ColVis : {
			classes : {
				masterButton : 'btn btn-primary'
			}
		}
	});
});