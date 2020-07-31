
const treatmentForm = document.getElementById("treatment");
const diagnosisId = document.getElementById("diagnosisId");
const drugId = document.getElementById("drugId");


diagnosisId.addEventListener("change", function (event) {
    if (!validateId(diagnosisId.value)) {
        removeClass(diagnosisId, "uk-form-success");
        addAnotherClass(diagnosisId, "uk-form-danger");
    } else {
        removeClass(diagnosisId, "uk-form-danger");
        addAnotherClass(diagnosisId, "uk-form-success")
    }
})

drugId.addEventListener("change", function (event) {
    if (!validateId(drugId.value)) {
        removeClass(drugId, "uk-form-success");
        addAnotherClass(drugId, "uk-form-danger");
    } else {
        removeClass(drugId, "uk-form-danger");
        addAnotherClass(drugId, "uk-form-success")
    }
})

submitButton.addEventListener("click", function() {
    if (validateTreatment()){
        removeClass(submitButton, "uk-animation-shake");
        removeClass(submitButton, "uk-button-danger");
        addAnotherClass(submitButton, "uk-button-primary");
        treatmentForm.submit();
        setTimeout(function() {
            makeIconVisible(checkIcon);
            treatmentForm.reset();
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

function validateTreatment() {
    return (
        validateId(diagnosisId.value)
        &&
        validateId(drugId.value)
    );
}
