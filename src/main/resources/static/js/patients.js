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
        let detailsButton = '<a href="#" onclick = "getMedicalRecordByPatientId('+patient.patientId+')" class="btn btn-success btn-icon-split"><span class="icon text-white-50"><i class="fas fa-check"></i></span><span class="text">Details</span></a>';
        let patientHTML = '<tr><td>'+patient.firstName+'</td><td>'+patient.lastName+'</td><td>'+patient.dob+'</td><td>'+patient.gender+'</td><td>'+patient.email+'</td><td>'+detailsButton+'</td></tr>';
        listHTML += patientHTML
    }

    document.querySelector('#dataTablePatients tbody').outerHTML = listHTML;
    $('#dataTablePatients').DataTable();
    console.log(patients);
}

async function getMedicalRecordByPatientId(patientId) {
    const request = await fetch('api/medical-records/patient/'+patientId, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    const patient = await request.json();
    if(patient){
        localStorage.setItem('selectedPatient', JSON.stringify(patient));
        window.location.href = 'detail-patient.html';
    }
}

window.onload = function(){
    const selectedPatient = JSON.parse(localStorage.getItem('selectedPatient'));

    if(selectedPatient){
        document.getElementById('patientFirstName').textContent = selectedPatient.patient.firstName;
        document.getElementById('patientLastName').textContent = selectedPatient.patient.lastName;
        document.getElementById('patientEmail').textContent = selectedPatient.patient.email;
        document.getElementById('patientDOB').textContent = selectedPatient.patient.dob;
        document.getElementById('patientGender').textContent = selectedPatient.patient.gender;
        document.getElementById('visitDate').textContent = selectedPatient.visitDate;
        document.getElementById('diagnosis').textContent = selectedPatient.diagnosis;
        document.getElementById('medication').textContent = selectedPatient.prescribedMedication;
        document.getElementById('notes').textContent = selectedPatient.notes;

    }
}






