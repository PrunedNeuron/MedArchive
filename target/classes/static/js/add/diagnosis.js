
const diagnosisForm = document.getElementById("diagnosis");

const consultationId = document.getElementById("consultationId");
const illnessId = document.getElementById("illnessId");

const checkIcon = document.getElementById("checkIcon");
const submitButton = document.getElementById("submitButton");


consultationId.addEventListener("change", function (event) {
    if (!validateId(consultationId.value)) {
        removeClass(consultationId, "uk-form-success");
        addAnotherClass(consultationId, "uk-form-danger");
    } else {
        removeClass(consultationId, "uk-form-danger");
        addAnotherClass(consultationId, "uk-form-success")
    }
})

illnessId.addEventListener("change", function (event) {
    if (!validateId(illnessId.value)) {
        removeClass(illnessId, "uk-form-success");
        addAnotherClass(illnessId, "uk-form-danger");
    } else {
        removeClass(illnessId, "uk-form-danger");
        addAnotherClass(illnessId, "uk-form-success")
    }
})

submitButton.addEventListener("click", function() {
    if (validateDiagnosis()){
        removeClass(submitButton, "uk-animation-shake");
        removeClass(submitButton, "uk-button-danger");
        addAnotherClass(submitButton, "uk-button-primary");
        diagnosisForm.submit();
        setTimeout(function() {
            makeIconVisible(checkIcon);
            diagnosisForm.reset();
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

function validateDiagnosis() {
    return (
        validateId(illnessId.value)
        &&
        validateId(consultationId.value)
    );
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