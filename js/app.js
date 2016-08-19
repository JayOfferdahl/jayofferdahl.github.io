var app = angular.module("PersonalPortfolioApp", []);

app.controller('MainController', ['$scope', function($scope) {
    $scope.user = {
    	name: 'Jay Offerdahl',
        nameShort: 'Jay O',
    };

    $scope.date = new Date();

    $scope.sections = [
        {
            anchor: '#about',
            title: 'about',
        },
    	{
    		anchor: '#internships',
    		title: 'internships',
    	},
        {
            anchor: '#projects',
            title: 'projects',
        },
        {
            anchor: '#involvement',
            title: 'involvement',
        },
    	{
            anchor: '#contact',
            title: 'contact',
        },
    ];

    // Scrolls to a specific anchor on the page, assumes the anchor exists
    $scope.scrollToSection = function(anchorName) {
        var targetOffset = $(anchorName).offset().top - 50;

        $('.scroll-container').mCustomScrollbar("scrollTo", "-=" + targetOffset, {
            scrollInertia:1500,
            scrollEasing:"easeInOut",
        });
    };

}]);

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