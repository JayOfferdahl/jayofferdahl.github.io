// JavaScript Document

var main = function() {
	
	//Nav brand hover animation
	$('.nav-brand a').mouseenter(function() {
			$(this).parent('div').stop().animate({
				backgroundColor: "#4D4D4D",
			}, 200);
		});
		
	$('.nav-brand a').mouseout(function() {
			$(this).parent('div').stop().animate({
				backgroundColor: "#303030",
			}, 200);
		});
};

$(document).ready(main);