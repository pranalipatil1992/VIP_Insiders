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

	$('.tier-button').click(function() {
		$('.tier-button, .tier-details').removeClass('active');
		var tier_name = $(this).attr('id').split('-')[0];

		$(this).addClass('active');
		$('#' + tier_name + '-details').addClass('active');
	});

	$('form input').focus(function() {
		$(this).parent().find('label').addClass('focused');
	}).blur(function() {
		if (!$(this).val()) {
			$(this).parent().find('label').removeClass('focused');
		}
	});

});