
const consultationForm = document.getElementById("consultation");

const patientId = document.getElementById("patientId");
const consultantId = document.getElementById("consultantId");
const consultationLocation = document.getElementById("consultationLocation");

patientId.addEventListener("change", function (event) {
    if (!validateId(patientId.value)) {
        removeClass(patientId, "formSuccess");
        addAnotherClass(patientId, "formDanger");
    } else {
        removeClass(patientId, "formDanger");
        addAnotherClass(patientId, "formSuccess")
    }
})

consultantId.addEventListener("change", function (event) {
    if (!validateId(consultantId.value)) {
        removeClass(consultantId, "formSuccess");
        addAnotherClass(consultantId, "formDanger");
    } else {
        removeClass(consultantId, "formDanger");
        addAnotherClass(consultantId, "formSuccess")
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
            makeIconVisible(checkIcon);
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
        validateId(patientId.value)
        &&
        validateId(consultantId.value)
        &&
        validateAddress(consultationLocation.value)
    );
}
