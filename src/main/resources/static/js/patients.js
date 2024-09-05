$(document).ready(function(){
    getPatients(); 
});

async function getPatients() {
    const request = await fetch('api/patients', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    const patients = await request.json();
    
    let listHTML = '';
    for(let patient of patients){
        let detailsButton = '<a href="#" onclick = "getPatient('+patient.patientId+')" class="btn btn-success btn-icon-split"><span class="icon text-white-50"><i class="fas fa-check"></i></span><span class="text">Details</span></a>';
        let patientHTML = '<tr><td>'+patient.firstName+'</td><td>'+patient.lastName+'</td><td>'+patient.dob+'</td><td>'+patient.gender+'</td><td>'+patient.email+'</td><td>'+detailsButton+'</td></tr>';
        listHTML += patientHTML
    }

    document.querySelector('#dataTablePatiens tbody').outerHTML = listHTML;
    $('#dataTablePatient').DataTable();
    console.log(patients);
}

async function getPatient(id) {
    const request = await fetch('api/patient/'+id, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    
    const patient = await request.json();
    if(patient){
        localStorage.setItem('selectedPatient', JSON.stringify(patient));
        window.location.href='detail-patient.html';
       
    }
}

window.onload = function() {
    const patient = JSON.parse(localStorage.getItem('selectedPatient'));
    if (patient) {
        document.getElementById('patientFirstName').textContent = patient.firstName;
        document.getElementById('patientLastName').textContent = patient.lastName;
        document.getElementById('patientEmail').textContent = patient.email;
        document.getElementById('patientDOB').textContent = patient.dob;
        document.getElementById('patientGender').textContent = patient.gender;
        // Añade más asignaciones si tienes más datos
    }
};

