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
    {
        primary: {
            anchor: '#about',
            title: 'about',
        },
    	secondary: {
    		anchor: '#portfolio',
    		title: 'portfolio',
    	},
    	tertiary: {
            anchor: '#contact',
            title: 'contact',
        },
    };

    $scope.scrollToSection = function( anchorName )
    {
        var targetOffset = $( anchorName ).offset().top - 70;

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