
// Load the function that loads the form entities on page when readystate is complete
document.onreadystatechange = function () {
    if (document.readyState === 'complete') {
        loadForm();
    }
}

//Fetches data from form and parses it to HTML as a list that loads all of the messages
async function loadForm() {

    const responseFromServer = await fetch('/load-form');

    const formContainer = document.getElementById('form-container');

    // The json() function returns an object that contains fields that we can
    // reference to create HTML.
    const myForm = await responseFromServer.json();

    //reference fields in myForm 
    console.log("Submissions:", myForm);   //This works


    const list = myForm; //const variable that stores the submissions as list

    //Displays list of form submissions in loadForm.html
    let docContainer = document.getElementById('form-container');

    //------------------------------------

    // creates a <table> element and a <tbody> element
    var tbl = document.getElementById("table");
    var tblBody = document.createElement("tbody");

    // creating all cells
    for (var i = 0; i < list.length; i++) {

        // creates a table row
        var row = document.createElement("tr");

        for (var j = 0; j < 3; j++) {
            // Create a <td> element and a text node, make the text
            // node the contents of the <td>, and put the <td> at
            // the end of the table row

            var cell = document.createElement("td");

            var cellText = document.createTextNode(list[i][j]);

            cell.appendChild(cellText);

            row.appendChild(cell);
        }

        // add the row to the end of the table body
        tblBody.appendChild(row);
    }

    // appends <table> into docContainer
    docContainer.appendChild(tblBody)

}