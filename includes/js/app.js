
// Scrolls to a specific anchor on the page, assumes the anchor exists
var scrollToSection = function(anchorName) {
    var targetOffset = $(anchorName).offset().top - 50;

    $('.scroll-container').mCustomScrollbar("scrollTo", "-=" + targetOffset, {
        scrollInertia:1500,
        scrollEasing:"easeInOut",
    });
};

$(document).ready(function () {
    // Hide the navbar collapsable menu when clicked
    $('.nav-collapse').click(function () {
        if($('#btnCollapse').css('display') != 'none') {
            $('#btnCollapse').click();
        }
    });

    // Initialize the custom scrollbar to the 'body' element
    $("body").mCustomScrollbar({
        theme: "minimal",
        scrollInertia: 500,
    });
});