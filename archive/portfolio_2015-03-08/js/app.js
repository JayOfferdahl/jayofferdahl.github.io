//Vertical scroll to specific div ID
var main = function() {	
	//******************************************************************	
	//
	//Animate the onload-overlay divs (when first entering the site), as well as animations
	//when page is accessed.
	//
	//******************************************************************	
	$(".overlay").click(function() {		
		//Flicker Animation
		var count = 0;
		var flicker = setInterval(function() { 
				$("#onload-hidden").toggleClass("hidden");
				$("#onload-show").toggleClass("hidden");
				
				if(count > 6) {
					clearInterval(flicker);
				}
					
					count++;
		}, 50);
		
		setTimeout(function() { $("#onload-hidden").removeClass("hidden"); }, 900);
		setTimeout(function() { $("#onload-show").addClass("hidden"); }, 900);
		
		$(".onload-overlay").delay(1200).animate({
			top: "-100vh"
		}, 800);
		$(".onload-overlay-bottom").delay(1200).animate({
			bottom: "-100vh"
		}, 900);
		
		//Show the Nav bar again
		setTimeout(function() { 
			$(".navbar").hide();
			$(".navbar").removeClass("hidden");
			$(".navbar").fadeIn(1500);
		}, 1300);
		
		//Fade in header (Image and text)
		setTimeout(function() { 
			$('header').hide();
			$('header').fadeIn(1500);	
		}, 1300);
	});
}
	
function scrollToElement(anchorName) {
	$('body,html').stop().animate({
		'scrollTop':   $('#' + anchorName).offset().top
	}, 2000);
}

$(document).ready(main);