
const illnessForm = document.getElementById("illness");
const illnessName = document.getElementById("illnessName");
const illnessDescription = document.getElementById("illnessDescription");
const illnessSymptoms = document.getElementById("illnessSymptoms");


illnessName.addEventListener("change", function (event) {
    if (!validateName(illnessName.value)) {
        removeClass(illnessName, "formSuccess");
        addAnotherClass(illnessName, "formDanger");
    } else {
        removeClass(illnessName, "formDanger");
        addAnotherClass(illnessName, "formSuccess")
    }
})

illnessDescription.addEventListener("change", function (event) {
    if (!validateDescription(illnessName.value)) {
        removeClass(illnessDescription, "formSuccess");
        addAnotherClass(illnessDescription, "formDanger");
    } else {
        removeClass(illnessDescription, "formDanger");
        addAnotherClass(illnessDescription, "formSuccess")
    }
})

illnessSymptoms.addEventListener("change", function (event) {
    if (!validateSymptoms(illnessSymptoms.value)) {
        removeClass(illnessSymptoms, "formSuccess");
        addAnotherClass(illnessSymptoms, "formDanger");
    } else {
        removeClass(illnessSymptoms, "formDanger");
        addAnotherClass(illnessSymptoms, "formSuccess")
    }
})

submitButton.addEventListener("click", function() {
    if (validateIllness()){
        removeClass(submitButton, "shakeAnimation");
        removeClass(submitButton, "buttonDanger");
        addAnotherClass(submitButton, "buttonPrimary");
        illnessForm.submit();
        setTimeout(function() {
            illnessForm.reset();
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
        validateDescription(illnessDescription.value)
        &&
        validateSymptoms(illnessSymptoms.value)
    );
}
