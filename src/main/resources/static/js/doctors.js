// This script fetches and displays a list of doctors in a table.
// It retrieves the doctor data from the server, populates the HTML table with the information,
// and initializes the DataTable plugin for sorting, searching, and pagination functionality.

$(document).ready(function(){
    getDoctors();
    $('#dataTableDoctors').DataTable();
});


async function getDoctors() {
    const request = await fetch('api/doctors', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    const users = await request.json();

    let listHTML = '';
    for(let user of users){
        let userHTML = '<tr><td>'+user.fname+'</td><td>'+user.lname+'</td><td>'+user.specialty+'</td><td>'+user.email+'</td><td>'+user.availability+'</td></tr>';
        listHTML += userHTML
    }

    document.querySelector('#dataTableDoctors tbody').outerHTML = listHTML;
    console.log(users);
}
