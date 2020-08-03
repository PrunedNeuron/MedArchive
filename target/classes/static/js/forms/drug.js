const drugForm = document.getElementById("drug");
const drugName = document.getElementById("drugName");
const drugClassification = document.getElementById("drugClassification");
const drugMechanism = document.getElementById("drugMechanism");

drugName.addEventListener("change", function (event) {
    if (!namePattern.test(drugName.value)) {
        removeClass(drugName, "formSuccess");
        addAnotherClass(drugName, "formDanger");
    } else {
        removeClass(drugName, "formDanger");
        addAnotherClass(drugName, "formSuccess")
    }
})

drugClassification.addEventListener("change", function (event) {
    if (!validateClassification(drugClassification.value)) {
        removeClass(drugClassification, "formSuccess");
        addAnotherClass(drugClassification, "formDanger");
    } else {
        removeClass(drugClassification, "formDanger");
        addAnotherClass(drugClassification, "formSuccess")
    }
})

drugMechanism.addEventListener("change", function (event) {
    if (!validateMechanism(drugMechanism.value)) {
        removeClass(drugMechanism, "formSuccess");
        addAnotherClass(drugMechanism, "formDanger");
    } else {
        removeClass(drugMechanism, "formDanger");
        addAnotherClass(drugMechanism, "formSuccess")
    }
})

submitButton.addEventListener("click", function () {
    if (validateDrug()) {
        removeClass(submitButton, "shakeAnimation");
        removeClass(submitButton, "buttonDanger");
        addAnotherClass(submitButton, "buttonPrimary");
        drugForm.submit();
        setTimeout(function () {
            drugForm.reset();
        }, 3000);
    } else {
        addAnotherClass(submitButton, "shakeAnimation");
        addAnotherClass(submitButton, "buttonDanger");
        setTimeout(function () {
            removeClass(submitButton, "shakeAnimation");
            removeClass(submitButton, "buttonDanger");
            addAnotherClass(submitButton, "buttonPrimary");
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
