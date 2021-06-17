
   

//Fetches data from form and parses it to HTML as a list that loads all of the messages

async function loadForm() {

    const responseFromServer = await fetch('/load-form');

    const formContainer = document.getElementById('form-container');

    // The json() function returns an object that contains fields that we can
    // reference to create HTML.
    const myForm = await responseFromServer.json();

    formContainer.innerText = myForm;

    //reference fields in myForm 
    console.log("Submissions:", myForm);   //This works kind off


}






