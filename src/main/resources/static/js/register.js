$(document).ready(function(){

});

async function registerDoctor() {
    
    let doctor = {};

    doctor.firstName = document.getElementById('txtFirstName').value;
    doctor.lastName = document.getElementById('txtLastName').value;
    doctor.email = document.getElementById('txtInputEmail').value;
    doctor.password = document.getElementById('txtInputPassword').value;
    
    let repeatPassword = document.getElementById('txtRepeatPassword').value;

    if(repeatPassword != doctor.password){
        alert('Password do not match. Please re-enter your password.');
        return;
    }

    const request = await fetch('/api/doctors/create', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(doctor)
    });

    alert('Your acount was created successfuly. Please login to access the website.');
    window.location.href = 'login.html';
    
}

