const drugForm = document.getElementById("drug");
const drugName = document.getElementById("drugName");
const drugClassification = document.getElementById("drugClassification");
const drugMechanism = document.getElementById("drugMechanism");

drugName.addEventListener("change", function (event) {
    if (!namePattern.test(drugName.value)) {
        removeClass(drugName, "uk-form-success");
        addAnotherClass(drugName, "uk-form-danger");
    } else {
        removeClass(drugName, "uk-form-danger");
        addAnotherClass(drugName, "uk-form-success")
    }
})

drugClassification.addEventListener("change", function (event) {
    if (!validateClassification(drugClassification.value)) {
        removeClass(drugClassification, "uk-form-success");
        addAnotherClass(drugClassification, "uk-form-danger");
    } else {
        removeClass(drugClassification, "uk-form-danger");
        addAnotherClass(drugClassification, "uk-form-success")
    }
})

drugMechanism.addEventListener("change", function (event) {
    if (!validateMechanism(drugMechanism.value)) {
        removeClass(drugMechanism, "uk-form-success");
        addAnotherClass(drugMechanism, "uk-form-danger");
    } else {
        removeClass(drugMechanism, "uk-form-danger");
        addAnotherClass(drugMechanism, "uk-form-success")
    }
})

submitButton.addEventListener("click", function () {
    if (validateDrug()) {
        removeClass(submitButton, "uk-animation-shake");
        removeClass(submitButton, "uk-button-danger");
        addAnotherClass(submitButton, "uk-button-primary");
        drugForm.submit();
        setTimeout(function () {
            makeIconVisible(checkIcon);
            drugForm.reset();
        }, 3000);
    } else {
        makeIconInvisible(checkIcon);
        addAnotherClass(submitButton, "uk-animation-shake");
        addAnotherClass(submitButton, "uk-button-danger");
        setTimeout(function () {
            removeClass(submitButton, "uk-animation-shake");
            removeClass(submitButton, "uk-button-danger");
            addAnotherClass(submitButton, "uk-button-primary");
        }, 1000);
    }

})

function validateMechanism(mechanism) {
    return mechanism.length >= 1 && mechanism != null;
}

function validateClassification(classification) {
    return classification.length >= 1 && classification != null;
}

function validateDrug() {
    return (
        validateName(drugName.value)
        && validateMechanism(drugMechanism.value)
        && validateClassification(drugClassification.value)
    );
}
