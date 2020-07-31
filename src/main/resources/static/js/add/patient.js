
const patientForm = document.getElementById("patient");
const patientName = document.getElementById("patientName");
const patientEmail = document.getElementById("patientEmail");
const patientAge = document.getElementById("patientAge");
const patientPhone = document.getElementById("patientPhone");
const patientGenderMale = document.getElementById("patientGenderMale");
const patientGenderFemale = document.getElementById("patientGenderFemale");



patientName.addEventListener("change", function (event) {
    if (!namePattern.test(patientName.value)) {
        removeClass(patientName, "uk-form-success");
        addAnotherClass(patientName, "uk-form-danger");
    } else {
        removeClass(patientName, "uk-form-danger");
        addAnotherClass(patientName, "uk-form-success")
    }
})

patientEmail.addEventListener("change", function (event) {
    if (!emailPattern.test(patientEmail.value)) {
        removeClass(patientEmail, "uk-form-success");
        addAnotherClass(patientEmail, "uk-form-danger");
    } else {
        removeClass(patientEmail, "uk-form-danger");
        addAnotherClass(patientEmail, "uk-form-success");
    }
})

patientAge.addEventListener("change", function (event) {
    if (!validateAge(patientAge.value)) {
        removeClass(patientAge, "uk-form-success");
        addAnotherClass(patientAge, "uk-form-danger");
    } else {
        removeClass(patientAge, "uk-form-danger");
        addAnotherClass(patientAge, "uk-form-success");
    }
})

patientPhone.addEventListener("change", function (event) {
    if (!phonePattern.test(patientPhone.value)) {
        removeClass(patientPhone, "uk-form-success");
        addAnotherClass(patientPhone, "uk-form-danger");
    } else {
        removeClass(patientPhone, "uk-form-danger");
        addAnotherClass(patientPhone, "uk-form-success");
    }
})

submitButton.addEventListener("click", function() {
    if (validatePatient()){
        removeClass(submitButton, "uk-animation-shake");
        removeClass(submitButton, "uk-button-danger");
        addAnotherClass(submitButton, "uk-button-primary");
        patientForm.submit();
        setTimeout(function() {
            makeIconVisible(checkIcon);
            patientForm.reset();
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

function validatePatient() {
    return (
        validateName(patientName.name)
        &&
        validateAge(patientAge.value)
        &&
        validateEmail(patientEmail.value)
        &&
        validatePhone(patientPhone.value)
        &&
        validateRadios(patientGenderMale, patientGenderFemale)
    );
}