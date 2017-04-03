var app = angular.module( "CoverLetterApp", ["xeditable"] );

app.run( function( editableOptions )
{
    editableOptions.theme = 'bs3';
});

app.controller( 'MainController', ['$scope', function( $scope ) {
    // Define your personal information for the header here
    $scope.user =
    {
        name: 'Jay Offerdahl',
        phone: '(573) - 673 - 5212',
        addressLine1: '5100 West 6th Street',
        addressLine2: 'Lawrence, KS 66049',
        email: 'jayofferdahl@ku.edu',
        website: 'jayofferdahl.com',
    };

    // Define the companies information here
    $scope.company =
    {
        name: 'Jaysanco Creative',
        addressLine1: '2950 Redford Ave.',
        addressLine2: 'Kansas City, MO 66215',
        date: new Date(),
        jobTitle: 'Lead Product Designer',
        recruiter: 'Sir/Madam', // Change this to your recruiters name, if you know it.
    };

    // Define your message here, add more paragraphs as necessary. (Doesn't have to follow formating of 'body1','body2')
    $scope.message =
    { 
        body1: "It is with great enthusiasm that I submit my application for the Lead Product Designer position at Jaysanco Creative.",
        body2: "As you will see from the attached resume, I've spent the past two years applying myself to a variety of projects and jobs. I received my first experience with web technologies by doing freelancing work for a couple key clients. I created the entire web experience for The Big Biscuit, located here in Kansas City. This project was, at first, challenging because my knowledge of the platforms was limited. However, I spent the time required to get the job done correctly and efficiently. I can proudly say that I learned an invaluable amount of information by working with The Big Biscuit, which allowed me to transition into my first internship.",
        body3: "During the summer of 2015, I interned with Garmin International, a cutting edge GPS company focused on providing complete and effective solutions to the wearables, marine, aviation, and auto GPS markets. This experience provided me with several software development skills: using Git version control, code review processes, and large-scale product development. Most importantly, I gained experience working with a team of peers and mentors in order to deliver quality solutions, which is similar to what I've heard exists at Jaysanco Creative.",
        body4: "Lastly, but certainly not least, I want you to know that I'm a huge fan of Jaysanco Creative and a supporter of the work that is accomplished there. I've lived in Kansas and Missouri for nearly my entire life, and I'm always excited to drive by the campuses and wonder about the magic that happens within.",
        body5: "I'm excited to have the chance to work at such a great company, and I believe that my programming abilities, paired with my communication skills, makes me an ideal candidate for this position. I'm available to start immeadiately following my graduation in mid-May. Thank you for your consideration, and I look forward to speaking to you soon.",
    }

    // Define your closer and closing name here, should you want to change it.
    $scope.footer =
    {
        closing: 'Sincerely',
        name: $scope.user.name, // This is in place to allow for different header & closer names (e.g. 'Franklin D. Roosevelt' in the header compared to 'Frank R.' in the footer)
    };
}]);

// Handles a change in paragraph text justification. Used when one of the options is changed.
function justifyText( format )
{
    // Activate the new button & switch justification type on the middle text.
    var buttons = ['#btn-lft', '#btn-jstfy', '#btn-cntr'];

    for( var i = 0; i < buttons.length; i++ )
    {
         $( buttons[i] ).removeClass( 'active' );
    }

    var alignment = 'left';

    switch( format ) {
        case 'center':
            alignment = 'jstfy-cntr';
            $( '#btn-cntr' ).addClass( 'active' );
            break;
        case 'justified':
            alignment = 'jstfy-jstfy';
            $( '#btn-jstfy' ).addClass( 'active' );
            break;
        // Default, left alignment
        case 'left':
        default:
            alignment = 'jstfy-lft';
            $( '#btn-lft' ).addClass( 'active' );

    }

    $( 'div.message > a ' ).removeClass();
    $( 'div.message > a ' ).addClass( alignment );
}