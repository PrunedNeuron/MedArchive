
const consultantForm = document.getElementById("consultant");

const patientId = document.getElementById("patientId");
const consultantId = document.getElementById("consultantId");
const consultationLocation = document.getElementById("consultationLocation");

const checkIcon = document.getElementById("checkIcon");
const submitButton = document.getElementById("submitButton");

const addressPattern = /^[a-zA-Z ]+$/;
const namePattern = /^[a-zA-Z ]{2,30}$/;
const emailPattern = /\S+@\S+\.\S+/;
const phonePattern = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/;


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

function makeIconVisible(icon) {
    icon.style.display = "";
}

function makeIconInvisible(icon) {
    icon.style.display = "none";
}

function validateConsultation() {
    return (
        validateId(patientId.value)
        &&
        validateId(consultantId.value)
        &&
        validateAddress(consultationLocation.value)
    );
}


function validateAddress(address) {
    return addressPattern.test(address)
}

function validateId(id) {
    return id > 0;
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