
const illnessForm = document.getElementById("illness");
const illnessName = document.getElementById("illnessName");
const illnessDescription = document.getElementById("illnessDescription");
const illnessSymptoms = document.getElementById("illnessSymptoms");


illnessName.addEventListener("change", function (event) {
    if (!validateName(illnessName.value)) {
        removeClass(illnessName, "uk-form-success");
        addAnotherClass(illnessName, "uk-form-danger");
    } else {
        removeClass(illnessName, "uk-form-danger");
        addAnotherClass(illnessName, "uk-form-success")
    }
})

illnessDescription.addEventListener("change", function (event) {
    if (!validateDescription(illnessName.value)) {
        removeClass(illnessDescription, "uk-form-success");
        addAnotherClass(illnessDescription, "uk-form-danger");
    } else {
        removeClass(illnessDescription, "uk-form-danger");
        addAnotherClass(illnessDescription, "uk-form-success")
    }
})

illnessSymptoms.addEventListener("change", function (event) {
    if (!validateSymptoms(illnessSymptoms.value)) {
        removeClass(illnessSymptoms, "uk-form-success");
        addAnotherClass(illnessSymptoms, "uk-form-danger");
    } else {
        removeClass(illnessSymptoms, "uk-form-danger");
        addAnotherClass(illnessSymptoms, "uk-form-success")
    }
})

submitButton.addEventListener("click", function() {
    if (validateIllness()){
        removeClass(submitButton, "uk-animation-shake");
        removeClass(submitButton, "uk-button-danger");
        addAnotherClass(submitButton, "uk-button-primary");
        illnessForm.submit();
        setTimeout(function() {
            makeIconVisible(checkIcon);
            illnessForm.reset();
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

function validateDescription(description) {
    return description != null && description != "";
}

function validateSymptoms(symptoms) {
    return symptoms != null && symptoms != "";
}

function validateIllness() {
    return (
        validateName(illnessName.value)
        &&
        validateDescription()
        &&
        validateSymptoms()
    );
}
