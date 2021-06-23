
//shows a error message if form has no email and prevents form from being sent

 addEventListener("click", function() {
    var email = document.forms["form1"]["email"].value;
    if (email === null || email === "") {
        document.getElementById('error').innerHTML = "*Mandatory*";
    }
});