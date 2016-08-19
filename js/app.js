var app = angular.module( "PersonalPortfolioApp", [] );

app.controller( 'MainController', ['$scope', function( $scope ) {
    $scope.user =
    {
    	name: 'Jay Offerdahl',
        nameShort: 'Jay O',
    	email: 'jaysanco@gmail.com',
    	phone: '(573) - 673 - 5212',
    };

    $scope.date = new Date();

    $scope.sections =
    [
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

    $scope.scrollToSection = function( anchorName )
    {
        var targetOffset = $( anchorName ).offset().top - 50;

        $( 'body, html' ).stop().animate( {
            'scrollTop': targetOffset
        }, 1000 );
    };

}]);

$( document ).ready( function () {

     $( '.nav-collapse' ).click( function ()
     {
        if( $( '#btnCollapse' ).css( 'display' ) != 'none' )
        {
            $( '#btnCollapse' ).click();
        }
    });
});