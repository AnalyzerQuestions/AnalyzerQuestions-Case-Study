	var startCronometer = function(){
		timer = new Timer();
		timer.start({countdown: true, startValues: {seconds: 180}});
		$('.cronometer').html(timer.getTimeValues().toString());
		timer.addEventListener('secondsUpdated', function (e) {
			$('.cronometer').html(timer.getTimeValues().toString());
		});
		timer.addEventListener('targetAchieved', function (e) {
			$('.cronometer').html('');
			$('#end-time').modal('show')
		});
	}; 
	
	startCronometer();