
const patientForm = document.getElementById("patient");
const patientName = document.getElementById("patientName");
const patientEmail = document.getElementById("patientEmail");
const patientAge = document.getElementById("patientAge");
const patientPhone = document.getElementById("patientPhone");
const patientGenderMale = document.getElementById("patientGenderMale");
const patientGenderFemale = document.getElementById("patientGenderFemale");



patientName.addEventListener("change", function (event) {
    if (!namePattern.test(patientName.value)) {
        removeClass(patientName, "formSuccess");
        addAnotherClass(patientName, "formDanger");
    } else {
        removeClass(patientName, "formDanger");
        addAnotherClass(patientName, "formSuccess")
    }
})

patientEmail.addEventListener("change", function (event) {
    if (!emailPattern.test(patientEmail.value)) {
        removeClass(patientEmail, "formSuccess");
        addAnotherClass(patientEmail, "formDanger");
    } else {
        removeClass(patientEmail, "formDanger");
        addAnotherClass(patientEmail, "formSuccess");
    }
})

patientAge.addEventListener("change", function (event) {
    if (!validateAge(patientAge.value)) {
        removeClass(patientAge, "formSuccess");
        addAnotherClass(patientAge, "formDanger");
    } else {
        removeClass(patientAge, "formDanger");
        addAnotherClass(patientAge, "formSuccess");
    }
})

patientPhone.addEventListener("change", function (event) {
    if (!phonePattern.test(patientPhone.value)) {
        removeClass(patientPhone, "formSuccess");
        addAnotherClass(patientPhone, "formDanger");
    } else {
        removeClass(patientPhone, "formDanger");
        addAnotherClass(patientPhone, "formSuccess");
    }
})

submitButton.addEventListener("click", function() {
    if (validatePatient()){
        removeClass(submitButton, "shakeAnimation");
        removeClass(submitButton, "buttonDanger");
        addAnotherClass(submitButton, "buttonPrimary");
        patientForm.submit();
        setTimeout(function() {
            makeIconVisible(checkIcon);
            patientForm.reset();
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