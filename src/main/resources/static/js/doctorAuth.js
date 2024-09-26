// This script handles the login process for doctors.
// It captures the user's email and password, sends them to the backend for authentication,
// and, based on the server's response, either redirects to the dashboard or shows an error message.

$(document).ready(function(){

});

async function loginSession(){

    let data = {};

    data.email = document.getElementById('txtInputEmail').value;
    data.password = document.getElementById('txtInputPassword').value;

    const request = await fetch('api/doctors/login',{
        method: 'POST',
        headers:{
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });

    const response = await request.text();
    console.log(response);

    if(response != 'Fail'){
        window.location.href = 'patients-table.html';
    }else{
        alert('Incorrect email or password, please try again');
    }
}
