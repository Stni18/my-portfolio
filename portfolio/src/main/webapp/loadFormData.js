
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
    let listContainer = document.createElement('ul');
    for (var i = 0; i < list.length; i++) {
        let submission = list[i];
        let elem = document.createElement('li');
        elem.appendChild(document.createTextNode(`${submission}`));
        listContainer.appendChild(elem);
    }
    docContainer.appendChild(listContainer);
 }