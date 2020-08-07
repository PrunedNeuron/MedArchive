
const treatmentForm = document.getElementById("treatment");
const diagnosisId = document.getElementById("diagnosisId");
const drugId = document.getElementById("drugId");


diagnosisId.addEventListener("change", function () {
    if (!validateId(diagnosisId.value)) {
        removeClass(diagnosisId, "formSuccess");
        addAnotherClass(diagnosisId, "formDanger");
    } else {
        removeClass(diagnosisId, "formDanger");
        addAnotherClass(diagnosisId, "formSuccess")
    }
})

drugId.addEventListener("change", function () {
    if (!validateId(drugId.value)) {
        removeClass(drugId, "formSuccess");
        addAnotherClass(drugId, "formDanger");
    } else {
        removeClass(drugId, "formDanger");
        addAnotherClass(drugId, "formSuccess")
    }
})

submitButton.addEventListener("click", function() {
    if (validateTreatment()){
        removeClass(submitButton, "shakeAnimation");
        removeClass(submitButton, "buttonDanger");
        addAnotherClass(submitButton, "buttonPrimary");
        treatmentForm.submit();
        setTimeout(function() {
            treatmentForm.reset();
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

function validateTreatment() {
    return (
        validateId(diagnosisId.value)
        &&
        validateId(drugId.value)
    );
}
