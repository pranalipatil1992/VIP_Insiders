$(document).ready(function() {
	
	$('.menu-link').click(function() {
		$('.menu-link').removeClass('active');
		$(this).toggleClass('active');
	});

	$('#register-tabs span').click(function() {
		$('#register-tabs span, .register-form').removeClass('active');
		var form_name = $(this).attr('id').split('-')[0];
		$('#' + form_name + '-tab').addClass('active');
		$('#' + form_name + '-form').addClass('active');
	});

});