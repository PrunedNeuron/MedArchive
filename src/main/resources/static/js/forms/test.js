const testForm = document.getElementById("test");

const consultationId = document.getElementById("consultationId")
const testName = document.getElementById("testName");
const testValue = document.getElementById("testValue");

consultationId.addEventListener("change", function () {
    if (!validateId(consultationId.value)) {
        removeClass(consultationId, "formSuccess");
        addAnotherClass(consultationId, "formDanger");
    } else {
        removeClass(consultationId, "formDanger");
        addAnotherClass(consultationId, "formSuccess")
    }
})

testName.addEventListener("change", function () {
    if (!validateDescription(testName.value)) {
        removeClass(testName, "formSuccess");
        addAnotherClass(testName, "formDanger");
    } else {
        removeClass(testName, "formDanger");
        addAnotherClass(testName, "formSuccess")
    }
})

testValue.addEventListener("change", function () {
    if (!validateDescription(testValue.value)) {
        removeClass(testValue, "formSuccess");
        addAnotherClass(testValue, "formDanger");
    } else {
        removeClass(testValue, "formDanger");
        addAnotherClass(testValue, "formSuccess")
    }
})


submitButton.addEventListener("click", function () {
    if (validateTest()) {
        removeClass(submitButton, "shakeAnimation");
        removeClass(submitButton, "buttonDanger");
        addAnotherClass(submitButton, "buttonPrimary");
        testForm.submit();
        setTimeout(function () {
            testForm.reset();
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

function validateDescription(description) {
    return description != null && description !== "";
}

function validateTest() {
    return (
        validateId(consultationId.value)
        &&
        validateDescription(testName.value)
        &&
        validateDescription(testValue.value)
    );
}
