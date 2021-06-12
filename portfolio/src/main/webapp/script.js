// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random programming language logo to the interactive page.
 */
function addRandomLanguage() {
    const greetings =
        ['c++', 'java', 'python', 'html'];

    // Pick a random Language.
    const language = greetings[Math.floor(Math.random() * greetings.length)];

    // Add it to the page.
    const languageContainer = document.getElementById('language-container');
    languageContainer.innerText = language;


    const imgElement = document.createElement('img');
    imgElement.src = 'images/' + languageContainer.innerText + '.jpg';

    const imageContainer = document.getElementById('random-image-container');

    //Remove the previous image.
    imageContainer.innerHTML = '';

    imageContainer.appendChild(imgElement);

}


/** Fetches the current date from the server and adds it to the page. */

async function showServerMessage() {

    const responseFromServer = await fetch('/hello');

    const greetingContainer = document.getElementById('greetings-container');

    // The json() function returns an object that contains fields that we can
    // reference to create HTML.
    const myMessages = await responseFromServer.json();

    //reference fields in myMessages 
    console.log("myMessages", myMessages);

    //------------------------------------------------------------------

    const secondResponseFromServer = await fetch('/random');

    const randomContainer = document.getElementById('random-container');

    const randomChoice = await secondResponseFromServer.json();

    randomContainer.innerText = randomChoice;

    //reference fields in randomMessage 
    console.log("randomMessage", randomChoice);
}


//shows a error message if form has no email and prevents form from being sent

 addEventListener("click", function(event) {
    var email = document.forms["form1"]["email"].value;
    if (email === null || email === "") {
        document.getElementById('error').innerHTML = "*Mandatory";
        event.preventDefault();
    }
});




