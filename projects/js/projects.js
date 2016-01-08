// JavaScript Document

var main = function() {
	toggleReturnBtn();
	
	$(window).resize(function() {
		toggleReturnBtn();
	});
	
};

$(document).ready(main);


var toggleReturnBtn = function() {
	if($(window).width() < 768)  {
			$('#returnBtn').removeClass('hidden');
			$('.returnText').addClass('hidden');
		}
		else {
			$('#returnBtn').addClass('hidden');
			$('.returnText').removeClass('hidden');
		}
};