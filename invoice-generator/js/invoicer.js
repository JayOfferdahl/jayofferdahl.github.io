(function() {
    var invoicer = angular.module('invoicer', ["xeditable", "ui.bootstrap"]);

    invoicer.run(function(editableOptions) {
        editableOptions.theme = 'bs3';
    });

    invoicer.controller('invController', function($scope){
        $scope.date = new Date();


        $scope.dt = new Date();
        $scope.open = function($event) {
            $event.preventDefault();
            $event.stopPropagation();

            $scope.opened = true;
        };

        $scope.dateOptions = {
            formatYear: 'yy',
            startingDay: 1
        };

        $scope.formats = ['dd-MMMM-yyyy', 'yyyy/MM/dd', 'dd.MM.yyyy', 'shortDate'];
        $scope.format = $scope.formats[0];





        $scope.our_address = "Jay Offerdahl";
        $scope.our_address_linetwo = "21473 W. 121st Terrace";
        $scope.our_city = "Olathe";
        $scope.our_state = "KS";
        $scope.our_zip = "66061";
        $scope.addressee = "Tobias";
        $scope.personal = "We really enjoyed working with you. Your story is one that we found unique and engaging. " +
            "We hope we were able to grant all your concept, design and development wishes. Please do not hesitate " +
            "to contact us with any questions or concerns. We look forward to watching your story unfold.";
        $scope.invoice = work;
        $scope.sidebar = notes;


        $scope.getSubTotal = function(){
            var subtotal=0;
            for(var i=0; i < $scope.invoice.line_items.length; i++) {
                var line = $scope.invoice.line_items[i];
                subtotal += (line.price * 1);
            }
            return subtotal;
        };

        $scope.addItem = function() {
            $scope.invoice.line_items.push(this.invoice.temp);
            $scope.invoice.temp = {};

        };
        $scope.addNote = function() {
            $scope.sidebar.note.push(this.sidebar.temp);
            $scope.sidebar.temp = {};
        };


        $scope.contentLoaded = true;

    });

    var notes =
    {
        note: [
            {
                title: "New note title",
                body: "This is the note body. Here you can elaborate on things that might be unclear."
            },
            {
                title: "New note title",
                body: "This is the note body. Here you can elaborate on things that might be unclear."
            }

        ]
    };
    // SOME ITEMS IN THE OBJECTS BELOW ARE NOT USED IN THE THIRD WISH INVOICE.HTML
    var work =
    {
        number: "1",
        bill_type: "Invoice",
        project_name: "Project Name",
        send_date: "",
        lead_in: "We promised to grant you...",
        due_date: "June 25, 2014",
        from_company: "My Company Name",
        from_address: "123 N6th St., STE 5",
        from_city: "Los angelas",
        from_state: "CA",
        from_zip: "83414",
        from_phone: "(573) 673-5212",
        from_email: "jaysanco@gmail.com",
        to_company: "Client Name",
        to_address: "Client Street Address",
        to_city: "City",
        to_state: "State",
        to_zip: "Zip Code",
        to_phone: "Client Phone",
        to_email: "Client Email",
        less_payments: "2000",
        line_items: [
            {
                title: "Agreeable brand concepts",
                milestone: "1",
                price: "100"
            },
            {
                title: "Wireframe and brand finalized",
                milestone: "1.5",
                price: "200"
            },
            {
                title: "Design Finalized",
                milestone: "2",
                price: "100"
            },
            {
                title: "Site coded and functional",
                milestone: "2.5",
                price: "400"
            },
            {
                title: "Site fully launched",
                milestone: "3",
                price: "200"
            }
        ]
    };

})();
