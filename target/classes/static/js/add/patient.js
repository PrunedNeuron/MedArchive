
const patientForm = document.getElementById("patient");

const patientName = document.getElementById("patientName");
const patientEmail = document.getElementById("patientEmail");
const patientAge = document.getElementById("patientAge");
const patientPhone = document.getElementById("patientPhone");
const patientGenderMale = document.getElementById("patientGenderMale");
const patientGenderFemale = document.getElementById("patientGenderFemale");

const checkIcon = document.getElementById("checkIcon");
const submitButton = document.getElementById("submitButton");

const namePattern = /^[a-zA-Z ]{2,30}$/;
const emailPattern = /\S+@\S+\.\S+/;
const phonePattern = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/;


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

function makeIconVisible(icon) {
    icon.style.display = "";
}

function makeIconInvisible(icon) {
    icon.style.display = "none";
}

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

function validatePhone(phone) {
    return phonePattern.test(phone)
}

function validateRadios(radioA, radioB) {
    return radioA.checked || radioB.checked;
}

function validateAge(age) {
    return parseInt(age) <= 122 && parseInt(age) >= 1;
}

function validateEmail(email) {
    return emailPattern.test(email);
}

function validateName(name) {
    return namePattern.test(name);
}

function addAnotherClass(element, addend) {
    const array = element.className.split(" ");
    if (array.indexOf(addend) == -1) {
        element.className += " " + addend;
    }
}

function removeClass(element, substring) {
    element.className = element.className.replaceAll(substring, "");
}