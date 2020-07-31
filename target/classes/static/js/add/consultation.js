
const consultantForm = document.getElementById("consultant");

const patientId = document.getElementById("patientId");
const consultantId = document.getElementById("consultantId");
const consultationLocation = document.getElementById("consultationLocation");

patientId.addEventListener("change", function (event) {
    if (!validateId(patientId.value)) {
        removeClass(patientId, "uk-form-success");
        addAnotherClass(patientId, "uk-form-danger");
    } else {
        removeClass(patientId, "uk-form-danger");
        addAnotherClass(patientId, "uk-form-success")
    }
})

consultantId.addEventListener("change", function (event) {
    if (!validateId(consultantId.value)) {
        removeClass(consultantId, "uk-form-success");
        addAnotherClass(consultantId, "uk-form-danger");
    } else {
        removeClass(consultantId, "uk-form-danger");
        addAnotherClass(consultantId, "uk-form-success")
    }
})

consultationLocation.addEventListener("change", function (event) {
    if (!validateAddress(consultationLocation.value)) {
        removeClass(consultationLocation, "uk-form-success");
        addAnotherClass(consultationLocation, "uk-form-danger");
    } else {
        removeClass(consultationLocation, "uk-form-danger");
        addAnotherClass(consultationLocation, "uk-form-success");
    }
})

submitButton.addEventListener("click", function() {
    if (validateConsultation()){
        removeClass(submitButton, "uk-animation-shake");
        removeClass(submitButton, "uk-button-danger");
        addAnotherClass(submitButton, "uk-button-primary");
        consultantForm.submit();
        setTimeout(function() {
            makeIconVisible(checkIcon);
            consultantForm.reset();
        }, 3000);
    }
    else {
        makeIconInvisible(checkIcon);
        addAnotherClass(submitButton, "uk-animation-shake");
        addAnotherClass(submitButton, "uk-button-danger");
        setTimeout(function() {
            removeClass(submitButton, "uk-animation-shake");
            removeClass(submitButton, "uk-button-danger");
            addAnotherClass(submitButton, "uk-button-primary");
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
