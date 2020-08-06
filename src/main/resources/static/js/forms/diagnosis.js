
const diagnosisForm = document.getElementById("diagnosis");

const consultationId = document.getElementById("consultationId");
const illnessId = document.getElementById("illnessId");

consultationId.addEventListener("change", function (event) {
    if (!validateId(consultationId.value)) {
        removeClass(consultationId, "formSuccess");
        addAnotherClass(consultationId, "formDanger");
    } else {
        removeClass(consultationId, "formDanger");
        addAnotherClass(consultationId, "formSuccess")
    }
})

illnessId.addEventListener("change", function (event) {
    if (!validateId(illnessId.value)) {
        removeClass(illnessId, "formSuccess");
        addAnotherClass(illnessId, "formDanger");
    } else {
        removeClass(illnessId, "formDanger");
        addAnotherClass(illnessId, "formSuccess")
    }
})

submitButton.addEventListener("click", function() {
    if (validateDiagnosis()){
        removeClass(submitButton, "shakeAnimation");
        removeClass(submitButton, "buttonDanger");
        addAnotherClass(submitButton, "buttonPrimary");
        diagnosisForm.submit();
        setTimeout(function() {
            diagnosisForm.reset();
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

function validateDiagnosis() {
    return (
        validateId(illnessId.value)
        &&
        validateId(consultationId.value)
    );
}
