
const consultationForm = document.getElementById("consultation");

const patientName = document.getElementById("patientName");
const consultantName = document.getElementById("consultantName");
const consultationLocation = document.getElementById("consultationLocation");

patientName.addEventListener("change", function (event) {
    if (!validateName(patientName.value)) {
        removeClass(patientName, "formSuccess");
        addAnotherClass(patientName, "formDanger");
    } else {
        removeClass(patientName, "formDanger");
        addAnotherClass(patientName, "formSuccess")
    }
})

consultantName.addEventListener("change", function (event) {
    if (!validateAddress(consultantName.value)) {
        removeClass(consultantName, "formSuccess");
        addAnotherClass(consultantName, "formDanger");
    } else {
        removeClass(consultantName, "formDanger");
        addAnotherClass(consultantName, "formSuccess")
    }
})

consultationLocation.addEventListener("change", function (event) {
    if (!validateAddress(consultationLocation.value)) {
        removeClass(consultationLocation, "formSuccess");
        addAnotherClass(consultationLocation, "formDanger");
    } else {
        removeClass(consultationLocation, "formDanger");
        addAnotherClass(consultationLocation, "formSuccess");
    }
})

submitButton.addEventListener("click", function() {
    if (validateConsultation()){
        removeClass(submitButton, "shakeAnimation");
        removeClass(submitButton, "buttonDanger");
        addAnotherClass(submitButton, "buttonPrimary");
        consultationForm.submit();
        setTimeout(function() {
            consultationForm.reset();
        }, 3000);
    }
    else {
        addAnotherClass(submitButton, "shakeAnimation");
        addAnotherClass(submitButton, "buttonDanger");
        setTimeout(function() {
            removeClass(submitButton, "shakeAnimation");
            removeClass(submitButton, "buttonDanger");
            addAnotherClass(submitButton, "buttonPrimary");
        }, 1000);
    }

})



function validateConsultation() {
    return (
        validateName(patientName.value)
        &&
        validateName(consultantName.value)
        &&
        validateAddress(consultationLocation.value)
    );
}
